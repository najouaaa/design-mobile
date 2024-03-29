package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemSelectedListener;

import com.test.R;
import com.test.editSettingsActivity;
import com.test.editSettingsActivity.MyOnItemSelectedListener;
import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSLocation;
import com.skyhookwireless.wps.WPSLocationCallback;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;
import com.skyhookwireless.wps.XPS;

public class Location extends Activity {
	Button btnStopService;
	TextView textBoxView;
	Intent intentMyService;
	Intent Skyhook;
	ComponentName service;
	BroadcastReceiver receiver;
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	private Handler _handler;
	Spinner spinner;
	boolean _stop = false;
	private static final int LOCATION_MESSAGE = 1;
	private static final int ERROR_MESSAGE = 2;
	private static final int DONE_MESSAGE = 3;
	int minDist = 50;
	int freq = 10000;
	String type = "skyhook";
	private final MyLocationCallback _callback = new MyLocationCallback();
	boolean skyhook = true;

	public void connectionHandler() {
		if (type.equals("skyhook")) {
			setUIHandler();
			XPS wps = new XPS(this);
			WPSAuthentication auth = new WPSAuthentication("salma_7amed",
					"German university in cairo");
			wps.getIPLocation(auth,
					WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP,
					_callback);

			// wps.getLocation(auth,
			// WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP,
			// _callback);

		} else {
			
	//		if(getIntent() != null){
			intentMyService = new Intent(this, MyGpsService.class);
			intentMyService.putExtra("minDist", Integer.parseInt(((EditText)findViewById(R.id.minDist)).getText().toString()));
			intentMyService.putExtra("freq",Integer.parseInt(((EditText)findViewById(R.id.freq)).getText().toString()));
	//		}
			service = startService(intentMyService);
			textBoxView.setText("MyGpsService started - (see DDMS Log)");
			IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
			receiver = new MyMainLocalReceiver();
			registerReceiver(receiver, mainFilter);
			btnStopService = (Button) findViewById(R.id.btnStopService);
			btnStopService.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					try {
						stopService(new Intent(intentMyService));
						textBoxView.setText("After stopping Service: \n"
								+ service.getClassName());
						btnStopService.setText("Finished");
						btnStopService.setClickable(false);
					} catch (Exception e) {
						Log.e("MYGPS", e.getMessage());
					}
				}
			});
		}
	}
	public void saveSettings(View view) {
		minDist = Integer.parseInt(((EditText) findViewById(R.id.minDist))
				.getText().toString());
		freq = Integer.parseInt(((EditText) findViewById(R.id.freq)).getText()
				.toString());
	
	}	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		spinner = (Spinner) findViewById(R.id.typeSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.typeArray, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
		
		textBoxView = (TextView) findViewById(R.id.txtMsg);
		// connectionHandler();

		final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.serviceToggle);
		togglebutton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Perform action on clicks
				if (togglebutton.isChecked()) {
					connectionHandler();
				} else {
					if(type.equals("gps"))
						stopService(new Intent(intentMyService));
				}
			}
		});
	}
	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			type = parent.getItemAtPosition(pos).toString();
			// Toast.makeText(parent.getContext(), "The selected type is " +
			// parent.getItemAtPosition(pos).toString(),
			// Toast.LENGTH_LONG).show();
		}

		public void onNothingSelected(AdapterView<?> parent) {
			// Do nothing.
		}
	}
	public void openSettings(View view) {
		Intent i = new Intent(getBaseContext(), editSettingsActivity.class);
		startActivity(i);
	}

	private void setUIHandler() {
		_handler = new Handler() {
			@Override
			public void handleMessage(final Message msg) {
				switch (msg.what) {
				case LOCATION_MESSAGE:
					textBoxView.setText(msg.obj.toString());
					Log.e("location msg", "ay kalam");
					return;
				case ERROR_MESSAGE:
					Log.e("error msg", ((WPSReturnCode) msg.obj).name());
					textBoxView.setText(((WPSReturnCode) msg.obj).name());
					return;
				case DONE_MESSAGE:
					Log.e("end", "false");
					_stop = false;
				}
			}
		};
	}

	private class MyLocationCallback implements IPLocationCallback,
			WPSLocationCallback {

		public void done() {
			// tell the UI thread to re-enable the buttons
			Log.e("location msg", "done");
			_handler.sendMessage(_handler.obtainMessage(DONE_MESSAGE));
		}

		public WPSContinuation handleError(final WPSReturnCode error) {
			Log.e("location msg", "error");
			// send a message to display the error

			_handler.sendMessage(_handler.obtainMessage(ERROR_MESSAGE, error));
			// return WPS_STOP if the user pressed the Stop button
			// if (! _stop)
			// return WPSContinuation.WPS_CONTINUE;
			// else
			return WPSContinuation.WPS_STOP;

		}

		public void handleIPLocation(final IPLocation location) {
			Log.e("location msg", "Handle IP Location");
			// send a message to display the location
			String x = " lat: " + location.getLatitude() + " " + " lon: "
					+ location.getLongitude();
			_handler.sendMessage(_handler.obtainMessage(LOCATION_MESSAGE, x));
			String msg = "Service Type: Skyhook IP" + "\nMin Distance: "
					+ minDist + "\nFrequency: " + freq + "\nLongitude: "
					+ location.getLongitude() + "\nLatitude: "
					+ location.getLatitude()
					+ "\n------------------------------------------\n";
			writeToFile(msg);
		}

		public void handleWPSLocation(final WPSLocation location) {
			Log.e("location msg", "Handle WPS Location");
			// send a message to display the location
			String x = " lat: " + location.getLatitude() + " " + " lon: "
					+ location.getLongitude();
			_handler.sendMessage(_handler.obtainMessage(LOCATION_MESSAGE, x));
			String msg = "Service Type: Skyhook IP" + "\nMin Distance: "
					+ minDist + "\nFrequency: " + freq + "\nLongitude: "
					+ location.getLongitude() + "\nLatitude: "
					+ location.getLatitude()
					+ "\n------------------------------------------\n";
			writeToFile(msg);
		}
	}

	private void writeToFile(String msg) {
		try {
			FileOutputStream fos = openFileOutput("comparison.txt", MODE_APPEND);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(msg);
			osw.flush();
			osw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class MyMainLocalReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context localContext, Intent callerIntent) {
			double latitude = callerIntent.getDoubleExtra("latitude", -1);
			double longitude = callerIntent.getDoubleExtra("longitude", -1);
			Log.e("onReceive - Latitude", Double.toString(latitude));
			Log.e("onReceive - Longitude", Double.toString(longitude));
			String msg = "Service Type: GPS/AGPS" + "\nMin Distance: "
					+ minDist + "\nFrequency: " + freq + "\nLongitude: "
					+ longitude + "\nLatitude: " + latitude
					+ "\n------------------------------------------\n";
			writeToFile(msg);
		}
	}
}