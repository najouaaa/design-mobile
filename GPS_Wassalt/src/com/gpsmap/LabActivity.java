package com.gpsmap;


import java.io.FileNotFoundException;
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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LabActivity extends Activity {

	Button btnStopService;    
	TextView txtMsg;
	Intent  intentMyService;
	ComponentName service;
	static long frequency = 10000;
	static float distance = 50;
	BroadcastReceiver receiver;
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// initiate the service
		intentMyService = new Intent(this, MyGpsService.class);
		MyGpsService.frequency = frequency;
		MyGpsService.distance = distance;
		service = startService(intentMyService);  
		txtMsg = (TextView) findViewById(R.id.txtMsg); 
		txtMsg.setText("MyGpsService started - (see DDMS Log)");
		// register & define filter for local listener
		IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
		receiver = new MyMainLocalReceiver();
		registerReceiver(receiver, mainFilter); 
		btnStopService = (Button) findViewById(R.id.btnStopService);
		btnStopService.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					stopService(new Intent(intentMyService) );
					txtMsg.setText("After stoping Service: \n" + 
							service.getClassName());
					btnStopService.setText("Finished");
					btnStopService.setClickable(false);
				} catch (Exception e) {
					Log.e("MYGPS", e.getMessage() );
				}
			}        
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		try {
			stopService(intentMyService);
			unregisterReceiver(receiver);
		} catch (Exception e) {
			Log.e ("MAIN-DESTROY>>>", e.getMessage() );
		}
		Log.e ("MAIN-DESTROY>>>" , "Adios" );
	}

	private class MyMainLocalReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context localContext, Intent callerIntent) {
			double latitude = callerIntent.getDoubleExtra("latitude",-1);
			double longitude = callerIntent.getDoubleExtra("longitude",-1);
			Log.e ("MAIN>>>",  Double.toString(latitude));
			Log.e ("MAIN>>>",  Double.toString(longitude));
			FileOutputStream fOut;
			try {
				fOut = openFileOutput("logLoc.txt", MODE_WORLD_READABLE);
			
			    OutputStreamWriter osw = new OutputStreamWriter(fOut);  
			    String logged="GPS,"+MyGpsService.frequency +","+MyGpsService.distance+","+Double.toString(latitude)+","+Double.toString(longitude)+","+System.currentTimeMillis(); 
			    osw.append(logged ); 
			    osw.flush(); 
			    osw.close();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			Intent i = new Intent(getBaseContext(), HelloMapViewActivity.class);
			i.putExtra("long",longitude);
			i.putExtra("lat",latitude);
			startActivity(i);
		}
	}
	}