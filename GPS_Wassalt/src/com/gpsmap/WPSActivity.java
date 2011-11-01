package com.gpsmap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.WPS;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSLocation;
import com.skyhookwireless.wps.WPSLocationCallback;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;

public class WPSActivity extends Activity {
	EditText txtBox;
	ProgressDialog dialog;
	double latitude, longitude, accuracy;
	String time, address, ipAddress;
	int nap, ncell;
	String result = "";
	IPLocation ipLocation;
	WPSLocation wpsLocation;
	IPLocationCallback ipCallback;
	WPSLocationCallback wpsCallback;
	// ------------------------------------------------------------------------------
	// boolean usingEmulator = true; // generate code for the EMULATOR
	boolean usingEmulator = false;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.obj.getClass().equals(String.class)) {
				Toast t = Toast.makeText(getApplicationContext(),
						"Some error occured, sorry.", 10);
				return;
			}
			if (msg.obj.getClass().equals(IPLocation.class)) {
				ipLocation = (IPLocation) msg.obj;
				latitude = ipLocation.getLatitude();
				longitude = ipLocation.getLongitude();
				// showing results
				result += "using IP,";
				result += "Latitude: " + latitude + "\n" + "Longitude: "
						+ longitude + "\n";
			} else {

				wpsLocation = (WPSLocation) msg.obj;
				latitude = wpsLocation.getLatitude();
				longitude = wpsLocation.getLongitude();
				// showing results
				result += "using WPS, ";
				result += "Latitude: " + latitude + "\n" + "Longitude: "
						+ longitude + "\n" + "Address: \n"
						+ wpsLocation.getStreetAddress() + "\n"
						+ "Accuracy (ft): " + wpsLocation.getHPE() + "\n";
			}
			// show results in the text box
			txtBox.setText(result);
			// get rid of the circular progress bar
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
		}
	};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.WPS);
		Toast t = Toast.makeText(getApplicationContext(), "Here 0", 0);
		t.show();
		dialog = new ProgressDialog(this);
		dialog.setMessage("Wait\ngetting your current location...");
		dialog.show();
	//	txtBox = (EditText) findViewById(R.id.txtBox);
		WPS wps = new WPS(getApplicationContext());
		WPSAuthentication auth = new WPSAuthentication("loai.ghoraba", "GUC");
		if (usingEmulator) {
			ipCallback = (IPLocationCallback) new MyIPLocationCallback(handler);
			wps.getIPLocation(auth,
					WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP,
					(IPLocationCallback) ipCallback);
		} else {
			wpsCallback = (WPSLocationCallback) new MyWPSLocationCallback(
					handler);
			wps.getLocation(auth,
					WPSStreetAddressLookup.WPS_FULL_STREET_ADDRESS_LOOKUP,
					(WPSLocationCallback) wpsCallback);
		}
	}

	private class MyWPSLocationCallback implements
			com.skyhookwireless.wps.WPSLocationCallback {
		Handler handler;

		public MyWPSLocationCallback(Handler handler) {
			this.handler = handler;
		}

		@Override
		public void done() {
			// TODO Auto-generated method stub

		}

		@Override
		public WPSContinuation handleError(WPSReturnCode error) {
			// TODO Auto-generated method stub
			Message msg = handler.obtainMessage();
			msg.obj = "Error";
			handler.sendMessage(msg);
			Log.e("Error", error.toString());
			return WPSContinuation.WPS_STOP;

		}

		@Override
		public void handleWPSLocation(WPSLocation location) {
			// TODO Auto-generated method stub
			Message msg = handler.obtainMessage();
			msg.obj = (WPSLocation) location;
			handler.sendMessage(msg);

		}

	}

	public class MyIPLocationCallback implements
			com.skyhookwireless.wps.IPLocationCallback {
		Handler handler;

		public MyIPLocationCallback(Handler handler) {
			this.handler = handler;
		}

		@Override
		public void done() {
			// TODO Auto-generated method stub

		}

		@Override
		public WPSContinuation handleError(WPSReturnCode arg0) {
			// TODO Auto-generated method stub
			Message msg = handler.obtainMessage();
			msg.obj = "Error";

			handler.sendMessage(msg);
			return WPSContinuation.WPS_STOP;

		}

		@Override
		public void handleIPLocation(IPLocation location) {
			// TODO Auto-generated method stub
			Message msg = handler.obtainMessage();
			msg.obj = (IPLocation) location;
			handler.sendMessage(msg);

		}

	}

}