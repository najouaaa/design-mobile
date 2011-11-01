package com.example.Location;

import java.util.List;

import com.example.Location.HelloItemizedOverlay;
import com.example.Location.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MyMap extends MapActivity {
	
	LinearLayout linearLayout;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedoverlay;


	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedoverlay = new HelloItemizedOverlay(drawable);
        
        displayCurrentPosition();
    }
	
	public void displayCurrentPosition(){
	
		int latitude = (int) (getIntent().getDoubleExtra("latitude",-1)*1000000);
		int longitude = (int)(getIntent().getDoubleExtra("longitude",-1)*1000000);
		GeoPoint point = new GeoPoint(latitude,longitude);
        OverlayItem overlayitem = new OverlayItem(point, "", "");
        itemizedoverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedoverlay);
		}
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		displayCurrentPosition();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		displayCurrentPosition();
	}
}
