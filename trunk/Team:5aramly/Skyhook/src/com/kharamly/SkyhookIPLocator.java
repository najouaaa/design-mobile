package com.kharamly;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;
import com.skyhookwireless.wps.XPS;

public class SkyhookIPLocator extends Activity {
	protected static final String TAG = "WPS ERROR";
	private static final int TIME_INTERVAL = 1000;
	private XPS xps;
	private WPSAuthentication auth;
	private IPLocationCallback callback;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		xps = new XPS(this);
		auth = new WPSAuthentication("kamasheto", "German University in Cairo");

		// Callback object
		callback = new IPLocationCallback() {
			public void done() {
				showToast("Done");
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						getLocation();
					}
				}, TIME_INTERVAL);
			}

			public void handleIPLocation(IPLocation location) {
				showToast("Latitude: " + location.getLatitude() + ", longitude: " + location.getLongitude());
			}

			public WPSContinuation handleError(WPSReturnCode error) {
				handleWPSError(error); // you'll implement handleWPSError()
				return WPSContinuation.WPS_CONTINUE;
			}

			private void handleWPSError(WPSReturnCode error) {
				// showToast("Error existed.");
				Log.e(TAG, "Error: " + error.name());
			}

		};

		getLocation();

	}

	private void getLocation() {
		xps.getIPLocation(auth, WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP, callback);
	}

	public void showToast(String text) {
		new AlertDialog.Builder(this).setMessage(text).setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		}).show();
	}
}