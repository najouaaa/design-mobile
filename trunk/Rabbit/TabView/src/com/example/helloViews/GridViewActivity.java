package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;


public class GridViewActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        createGridView();
    }
    
    public void createGridView(){
    	
    	setContentView(R.layout.grid_view);
    	// Create grid view
    	GridView gv = (GridView) findViewById(R.id.gridview);
    	// Bind to data source
    	gv.setAdapter(new ImageAdapter(this));
    	
    	// Add click handler for each item to open detailed view
       	gv.setOnItemClickListener(new OnItemClickListener() {
    		   public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        
				ImageView iv = (ImageView) v;
				int animalNameId = (Integer) iv.getTag();
				String animalName = getString(animalNameId);
				// Generate intent to move between activities
				Intent mIntent = new Intent(getApplicationContext(),
						HoroscopeInfoActivity.class);
				// Pass variable to detailed view activity using the intent
				mIntent.putExtra(TabViewActivity.ANIMAL_KEY,
						animalName);
				// Start the new activity
				startActivity(mIntent);
    	   					 	
              }// end onItemClick
		});
    	
    }// end createGridView

    
}