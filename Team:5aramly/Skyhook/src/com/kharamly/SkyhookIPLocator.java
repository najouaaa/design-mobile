package com.kharamly;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;
import com.skyhookwireless.wps.XPS;

public class SkyhookIPLocator extends Activity {
	protected static final String TAG = "WPS ERROR";
	private int TIME_INTERVAL = 1000;
	private XPS xps;
	private WPSAuthentication auth;
	private IPLocationCallback callback;
	private boolean serviceOn = false;
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	Intent myGpsService;
	Intent myAGpsService;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		// final Button start_end = (Button) findViewById(R.id.MainButton);
		// start_end.setOnClickListener(new OnClickListener() {
		//
		// public void onClick(View arg0) {
		// if (serviceOn) {
		// // endWPSService();
		// endGpsService();
		// // endAGpsService();
		// start_end.setText(R.string.start);
		// } else {
		// // startAGpsService();
		// startGpsService();
		// // startWPSService();
		// start_end.setText(R.string.end);
		// }
		// serviceOn = !serviceOn;
		// }
		//
		// });

	}

	private void endWPSService() {

	}

	private void startWPSService() {
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
				showToast("Latitude: " + location.getLatitude()
						+ ", longitude: " + location.getLongitude());
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
		xps.getIPLocation(auth,
				WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP, callback);
	}

	public void showToast(String text) {
		new AlertDialog.Builder(this)
				.setMessage(text)
				.setNegativeButton("Dismiss",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						}).show();
	}

	private void startGpsService() {
		myGpsService = new Intent(this, MyGpsService.class);
		startService(myGpsService);
		// register & define filter for local listener
		IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
		MyMainLocalReceiver receiver = new MyMainLocalReceiver();
		registerReceiver(receiver, mainFilter);
	}

	private void endGpsService() {
		stopService(myGpsService);
	}

	private void startAGpsService() {
		myAGpsService = new Intent(this, MyGpsService.class);
		startService(myAGpsService);
		// register & define filter for local listener
		IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
		MyMainLocalReceiver receiver = new MyMainLocalReceiver();
		registerReceiver(receiver, mainFilter);
	}

	private void endAGpsService() {
		stopService(myAGpsService);
	}

	private class MyMainLocalReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context localContext, Intent callerIntent) {
			double latitude = callerIntent.getDoubleExtra("latitude", -1);
			double longitude = callerIntent.getDoubleExtra("longitude", -1);
			Log.e("MAIN>>>", Double.toString(latitude));
			Log.e("MAIN>>>", Double.toString(longitude));
			String msg = " lat: " + Double.toString(latitude) + " " + " lon: "
					+ Double.toString(longitude);
			System.out.println(msg);

		}
	}
}