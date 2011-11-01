package com.gps.local;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Localization_SheelActivity extends Activity {
    /** Called when the activity is first created. */
	
	LinearLayout linearLayout;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedOverlay;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new HelloItemizedOverlay(drawable);
        
        GeoPoint point = new GeoPoint(19240000,-99120000);
        addLocation(point);
     
        GeoPoint point2 = new GeoPoint(35410000, 139460000);
        addLocation(point2);
        
        mapOverlays.add(itemizedOverlay);
    }
    
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    public void addLocation(GeoPoint point){
    	
    	OverlayItem overlayitem = new OverlayItem(point, "", "");
        itemizedOverlay.addOverlay(overlayitem);
    	
    }
}