package com.example.Location;

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
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class LocationActivity extends Activity {
	
	
	Button btnStopService;    
	TextView txtMsg;
	RadioGroup myRadioGroup;
	RadioButton radioBtn1;
	RadioButton radioBtn2;
	RadioButton radioBtn3;
	TextView frequencyTextView;
	TextView distanceTextView;
	Button startBtn;
	Intent  intentMyService;
	ComponentName service;
	BroadcastReceiver receiver;
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	String Data="";

    /** Called when the activity is first created. */
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setContentView(R.layout.main);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        
        frequencyTextView = (TextView) findViewById(R.id.freqTextView);
        distanceTextView = (TextView) findViewById(R.id.distTextView);
        startBtn = (Button) findViewById(R.id.start); 
        btnStopService = (Button) findViewById(R.id.btnStopService);
        myRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioBtn1 = (RadioButton) findViewById(R.id.radioBtn1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioBtn2);
        radioBtn3 = (RadioButton) findViewById(R.id.radioBtn3);
        
        
        // Start Service Button 
        startBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            try {
            
            	btnStopService.setText("Stop Service");
            	btnStopService.setEnabled(true);
            	
            	// Initiate the service
            	// GPS
            	if(myRadioGroup.getCheckedRadioButtonId()==radioBtn1.getId())
            	{      	
	                intentMyService = new Intent(LocationActivity.this, MyGpsService.class);
	                service = startService(intentMyService);  
	                txtMsg.setText("MyGpsService started - (see DDMS Log)");
	                // register & define filter for local listener
	                IntentFilter mainFilter = new IntentFilter(GPS_FILTER);
	                receiver = new MyMainLocalReceiver();
	                registerReceiver(receiver, mainFilter); 
	                String freq="";
	            	String dist="";       
	                freq=frequencyTextView.getText().toString();
	                dist= distanceTextView.getText().toString();
	                
	                long f = Long.valueOf(freq.trim()).longValue();
	               	MyGpsService.frequency=(long)f;
	               	Context context = getApplicationContext();
	               	Toast.makeText(context,"frequency:"+MyGpsService.frequency , 0).show();
	               
	                float d = Float.valueOf(dist.trim()).floatValue();
	                MyGpsService.distance=d;
	               	Toast.makeText(context,"distance:"+MyGpsService.distance , 0).show();
            	}
            	
            	// AGPS
            	if(myRadioGroup.getCheckedRadioButtonId()==radioBtn2.getId())
            	{
            		/* Initiating AGPS service */
            		Context context = getApplicationContext();
	               	Toast.makeText(context,"AGPS selected" , 0).show();
            	}
                
            	// Skyhook
            	if(myRadioGroup.getCheckedRadioButtonId()==radioBtn3.getId())
            	{
            		/* Initiating Skyhook service */
            		Context context = getApplicationContext();
	               	Toast.makeText(context,"Skyhook selected" , 0).show();
            	}
                       
            } catch (Exception e) {
            Log.e("MYGPS", e.getMessage() );
            }
            }        
            });
        
        
        // Stop Service Button
        
        btnStopService.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
        try {
        stopService(new Intent(intentMyService) );
        txtMsg.setText("After stoping Service: \n" + 
        service.getClassName());
        btnStopService.setText("Finished");
        btnStopService.setEnabled(false);
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
		String msg = " lat: " + Double.toString(latitude) + " "
		+ " lon: " + Double.toString(longitude);
		txtMsg.append("\n" + msg);
		//testing the SMS-texting feature
		texting(msg);
		
		try { 
		       // catches IOException below
		       Data=Data+"\nLatitude="+Double.toString(latitude)+" "+
		    "Longitude="+Double.toString(longitude)+" \n"+batteryLevel()+"\n";

		
		        
		       FileOutputStream fOut = openFileOutput("samplefile.txt",
		                                                            MODE_WORLD_READABLE);
		       OutputStreamWriter osw = new OutputStreamWriter(fOut); 

		       // Write the string to the file
		       osw.write(Data);

		    
		       osw.flush();
		       osw.close();


		    } catch (IOException ioe) 
		      {ioe.printStackTrace();}
		}
		

		}
	
	private void texting(String msg){
		try {
		SmsManager smsMgr = SmsManager.getDefault();
		// Parameter of sendTextMessage are:
		//  destinationAddress, senderAddress,
		//  text, sentIntent, deliveryIntent)
		//----------------------------------------------------------
		smsMgr.sendTextMessage("5556", "5551234", 
		"Please meet me at: " + msg, 
		null, null);
		} catch (Exception e) {
		Toast.makeText(this, "texting\n" + e.getMessage(), 1).show();
		}
		}// texting
	
	String s="";
	 private String batteryLevel() {
		 
	        BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
	            public void onReceive(Context context, Intent intent) {
	                context.unregisterReceiver(this);
	                int rawlevel = intent.getIntExtra("level", -1);
	                int scale = intent.getIntExtra("scale", -1);
	                int level = -1;
	                if (rawlevel >= 0 && scale > 0) {
	                    level = (rawlevel * 100) / scale;
	                }
	          s="Battery Level Remaining: " + level + "%";
	            }
	        };
	        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
	        registerReceiver(batteryLevelReceiver, batteryLevelFilter);
	        return s;
	    }
	
	

}