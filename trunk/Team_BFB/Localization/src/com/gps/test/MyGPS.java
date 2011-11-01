package com.gps.test;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyGPS extends Activity {
	Button btnStopService;    
	TextView txtMsg;
	Intent  intentMyService;
	ComponentName service;
	BroadcastReceiver receiver;
	String GPS_FILTER = "guc.action.GPS_LOCATION";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        

 
        
//        txtMsg = (TextView) findViewById(R.id.txtMsg); 
        // initiate the service
        intentMyService = new Intent(this, MyGpsService.class);        
           
        
     //   txtMsg.setText("MyGpsService started - (see DDMS Log)");
        // register & define filter for local listener
        IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
    //    Toast.makeText(this, "texting\n" , 1).show();
        receiver = new MyMainLocalReceiver();
        registerReceiver(receiver, mainFilter); 
     
        
        
        final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.serviceToggle);
        togglebutton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
                if (togglebutton.isChecked()) {
                	intentMyService.putExtra("minDist", getIntent().getIntExtra("minDist", 50));
                	intentMyService.putExtra("freq", getIntent().getIntExtra("freq", 10000));
                	service = startService(intentMyService);
                	
                } else {
                    stopService(new Intent(intentMyService) );
                }
            }
        });
        

    }
  public void openSettings(View view)
  {
	  Intent i = new Intent(getBaseContext(), editSettingsActivity.class);
	  startActivity(i);
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
//    	String msg = " lat: " + Double.toString(latitude) + " "	+ " lon: " + Double.toString(longitude);
//    	txtMsg.append("\n" + msg);
//    	//testing the SMS-texting feature
//    	texting(msg);
    	}
//
//    	
//    	
//    	}
//    private void texting(String msg){
//		try {
//		SmsManager smsMgr = SmsManager.getDefault();
//		// Parameter of sendTextMessage are:
//		//  destinationAddress, senderAddress,
//		//  text, sentIntent, deliveryIntent)
//		//----------------------------------------------------------
//		smsMgr.sendTextMessage("5556", "5551234", 
//		"Please meet me at: " + msg, 
//		null, null);
//		} catch (Exception e) {
//		Toast.makeText(this, "texting\n" + e.getMessage(), 1).show();
//		}
//		}// texting
    }
}

