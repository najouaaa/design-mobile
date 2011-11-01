package com.gpsmap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public class AGpsService extends Service {
	String GPS_FILTER = "guc.action.GPS_LOCATION";
	Thread triggerService;
	LocationManager lm;
	GPSListener myLocationListener;
	boolean isRunning = true;
	static long frequency = 10000;
	static float distance = 50;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onStart(Intent intent, int startId) {
		Log.e("<<AGpsService-onStart>>", "I am alive-AGPS!");
		// we place the slow work of the service in its own thread so the 
		// response we send our caller who run a "startService(...)" method 
		// gets a quick OK from us.
		triggerService = new Thread(new Runnable() {
			public void run() {
				try {
					Looper.prepare();
					// try to get your GPS location using the LOCATION.SERVIVE provider
					lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
					//lm = getSystemService(TELEPHONY_SERVICE)
					// This listener will catch and disseminate location updates
					myLocationListener = new GPSListener();
					//long minTime = 10000;  // frequency update: 10 seconds
					//float minDistance = 50;  // frequency update: 50 meter
					lm.requestLocationUpdates( //request GPS updates
							LocationManager.NETWORK_PROVIDER,
							frequency, 
							distance, 
							myLocationListener);
					Looper.loop();
				} catch (Exception e) {
					Log.e("AGPS", e.getMessage() );
				}
			}// run
		});
		triggerService.start();


	}

	private class GPSListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			//capture location data sent by current provider
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			//assemble data bundle to be broadcasted
			Intent myFilteredResponse = new Intent(GPS_FILTER);
			myFilteredResponse.putExtra("latitude", latitude);
			myFilteredResponse.putExtra("longitude", longitude);
			Log.e(">>AGPS_Service<<", "Lat:" + latitude + " lon:" + longitude);
			//send the location data out
			sendBroadcast(myFilteredResponse);

		}
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}
	}
	

}
