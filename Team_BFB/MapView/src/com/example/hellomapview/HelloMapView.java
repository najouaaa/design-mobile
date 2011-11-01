package com.example.hellomapview;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.hardware.GeomagneticField;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class HelloMapView extends MapActivity {
	LinearLayout linearLayout;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedOverlay;
	//GeoPoint point = new GeoPoint(19240000,-99120000);
	//GeoPoint point = new GeoPoint(0,0);
	GeoPoint point = new GeoPoint((int)GPSTestActivity.latitude,(int)GPSTestActivity.longitude);
	//GeoPoint point=new GeomagneticField(gdLatitudeDeg, gdLongitudeDeg, altitudeMeters, timeMillis)
	OverlayItem overlayitem = new OverlayItem(point, "", "");
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new HelloItemizedOverlay(drawable);
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
  
       
        
    }

	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
}