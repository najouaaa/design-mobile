package com.example.hellomapview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class GPSTestActivity extends Activity {
	Button btnStopService;    
	TextView txtMsg;
	Intent  intentMyService;
	ComponentName service;
	BroadcastReceiver receiver;
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	public static double latitude;
	public static double longitude;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtMsg = (TextView) findViewById(R.id.txtMSg); 
        // initiate the service
        intentMyService = new Intent(this, MyGpsService.class);        
        service = startService(intentMyService);   
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
		 latitude = callerIntent.getDoubleExtra("latitude",-1);
		 longitude = callerIntent.getDoubleExtra("longitude",-1);
		Log.e ("MAIN>>>",  Double.toString(latitude));
		Log.e ("MAIN>>>",  Double.toString(longitude));
		String msg = " lat: " + Double.toString(latitude) + " "
		+ " lon: " + Double.toString(longitude);
		txtMsg.append("\n" + msg);
		//testing the SMS-texting feature
		texting(msg);
		}
		
			
		}
	@SuppressWarnings("deprecation")
	private void texting(String msg){
		try {
			
		
		SmsManager smsMgr = SmsManager.getDefault();
		// Parameter of sendTextMessage are:
		//  destinationAddress, senderAddress,
		//  text, sentIntent, deliveryIntent)
		//----------------------------------------------------------
		
		smsMgr.sendTextMessage("5556", "5551234", "Please meet me at: " + msg, null, null);
		
		} catch (Exception e) {
		Toast.makeText(this, "texting\n" + e.getMessage(), 1).show();
		}
		}// texting
}