package com.example.HelloMapView;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

@SuppressWarnings("rawtypes")
public class HelloItemizedOverlay extends ItemizedOverlay {
	
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

	public HelloItemizedOverlay(Drawable arg0) {
		super(boundCenterBottom(arg0));
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}
	
	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	@Override
	protected OverlayItem createItem(int i) {
	  return mOverlays.get(i);
	}

}
