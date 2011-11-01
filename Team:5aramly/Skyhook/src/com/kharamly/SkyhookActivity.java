package com.kharamly;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class SkyhookActivity extends MapActivity {

	String GPS_FILTER = "guc.action.GPS_LOCATION";
	Intent myGpsService;
	Intent myAGpsService;
	private boolean serviceOn = true;
	
	private int runningService = 0;
	public int TIME_INTERVAL = 1000;
	public int MIN_DISTANCE = 1000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
		HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable);
		GeoPoint point = new GeoPoint(19240000,-99120000);
		OverlayItem overlayitem = new OverlayItem(point, "", "");
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		endCurrentService();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		String x = sharedPrefs.getString("updates_interval", "1000");
		TIME_INTERVAL = Integer.parseInt(x);
		x = sharedPrefs.getString("distance", "100");
		MIN_DISTANCE = Integer.parseInt(x);
		x = sharedPrefs.getString("type", "0");
		runningService = Integer.parseInt(x);
		Toast.makeText(this, sharedPrefs.getString("type", "0"), Toast.LENGTH_SHORT).show();
		if(serviceOn)
			startNewService();
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			Intent i = new Intent(SkyhookActivity.this, SettingsActivity.class);
			startActivity(i);
			return true;
		case R.id.start_end_service:
			if(serviceOn)
				{
				endCurrentService();
				item.setTitle(R.string.start);
				}
			else
			{
				startNewService();
				item.setTitle(R.string.end);
			}
			serviceOn = !serviceOn;
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void startNewService()
	{
		switch(runningService)
		{
		case 0 : return;
		case 1 : startGpsService();
		case 2 : startAGpsService();
		}		
	}
	
	public void endCurrentService()
	{
		switch(runningService)
		{
		case 0 : return;
		case 1 : endGpsService(); return;
		case 2 : endAGpsService(); return;
		}		
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