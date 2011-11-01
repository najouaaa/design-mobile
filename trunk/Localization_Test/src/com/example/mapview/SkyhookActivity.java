/*package com.example.mapview;

import com.example.mapview.CIPLocationCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.IPLocationCallback;
import com.skyhookwireless.wps.WPS;
import com.skyhookwireless.wps.WPSAuthentication;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSReturnCode;
import com.skyhookwireless.wps.WPSStreetAddressLookup;
import com.skyhookwireless.wps.XPS;


public class SkyhookActivity extends Activity {
	protected static final String TAG = null;
	static IPLocation il;
	static String deb = "start -> ";
	static SkyhookActivity za;
	double latitude, longitude, accuracy;
	String time, address, ipAddress;String result;
	
	ProgressDialog dialog;
	IPLocation ipLocation;
	IPLocationCallback ipCallback;
	boolean usingEmulator = true;  
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
		super.handleMessage(msg);
		if ((msg.arg1 > 360) && (msg.arg2 > 360)) {
		// error situation
		Toast.makeText(getApplicationContext(), 
		"Problem obtaining location\try agai...", 1).show();
		finish();
		}
		result = "Skyhook Emulator:" + usingEmulator + "\n\n";
		if (msg.obj.getClass().equals(IPLocation.class)) {
		ipLocation = (IPLocation)msg.obj;
		latitude = ipLocation.getLatitude();     // HERE YOU GET THE LOCATION
		longitude = ipLocation.getLongitude();   // HERE YOU GET THE LOCATION
		// showing results
		result += "Latitude:  " + latitude + "\n" +
		"Longitude: " + longitude + "\n" +
		 
		"IP:   " + ipLocation.getIP() + "\n"; 
	
		}
		  TextView tv = (TextView) findViewById(R.id.zeft);
		// show results in the text box
		tv.setText(result);
		if (dialog.isShowing()) {
			dialog.dismiss();
			}
			 
			}    
			};
	
	
	
	
	
	
	
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        dialog = new ProgressDialog(this);
        dialog.setMessage("Wait\ngetting your current location...");
        dialog.show();
        WPS wps = new WPS(getApplicationContext());
        WPSAuthentication auth = new WPSAuthentication("mohsenguc", "mohsenguc");
       
        if (usingEmulator) {
        	Log.e("<<MAIN GETLOCATION>>", "asking for IP services...");
        	ipCallback = (IPLocationCallback) new CIPLocationCallback(handler);
        	wps.getIPLocation(auth,
        	WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP,                                 
        	(IPLocationCallback) ipCallback);
        	}
        
       
        
        }
    }

*/
 
