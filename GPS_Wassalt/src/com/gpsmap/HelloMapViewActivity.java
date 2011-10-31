package com.gpsmap;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class HelloMapViewActivity extends MapActivity {
	
	RelativeLayout layout;
	MapView mapView;
	
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedoverlay;
    /** Called when the activity is first created. */
	/* **/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedoverlay = new HelloItemizedOverlay(drawable);
        
        displayLoc();
        
    }
    
    private void displayLoc(){
    	//get position
    	int longi = (int)(getIntent().getDoubleExtra("long", 0))*1000000;
        int lat = (int)(getIntent().getDoubleExtra("lat", 0))*1000000;
        GeoPoint point = new GeoPoint(lat, longi);
        
        OverlayItem overlayitem = new OverlayItem(point, "", "");
        itemizedoverlay.addOverlay(overlayitem);
        //itemizedoverlay.set(0,overlayitem);
        //mapOverlays.set(0, itemizedoverlay);
       // mapView.refreshDrawableState();
        
        mapOverlays.add(itemizedoverlay);
    	
    }
    @Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		displayLoc();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		displayLoc();
        
	}

	@Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}