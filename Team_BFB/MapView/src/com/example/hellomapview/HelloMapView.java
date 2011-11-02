package com.example.hellomapview;

import java.util.List;

import android.graphics.drawable.Drawable;
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
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new HelloItemizedOverlay(drawable);
       // itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
        showLocation();
    }
    public void showLocation()
    {
    	//GeoPoint point = new GeoPoint(19240000,-99120000);
    	int longi = (int)(getIntent().getDoubleExtra("longtitude", 0))*1000000;
        int lat = (int)(getIntent().getDoubleExtra("latitude", 0))*1000000;
        //GeoPoint point = new GeoPoint(lat, longi);
        GeoPoint point = new GeoPoint((int)GPSTestActivity.lat,(int) GPSTestActivity.lon);
    	OverlayItem overlayitem = new OverlayItem(point, "", "");
    	itemizedOverlay.addOverlay(overlayitem);
    }

	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
}