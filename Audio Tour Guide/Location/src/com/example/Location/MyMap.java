package com.example.Location;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MyMap extends MapActivity {
	
	LinearLayout linearLayout;
	MapView mapView;

	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
	}
}
