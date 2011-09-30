package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

public class TableViewActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.table_view);
    }
    
    
     
    public void onClickRow(View v) {
		    	  	
		TableRow tr = (TableRow) v;
		// Get the name of the animal (attached to the tag)
		String animalName = (String) tr.getTag();
		// Generate intent to move between activities
		Intent mIntent = new Intent(getApplicationContext(),
				HoroscopeInfoActivity.class);
		// Pass variable to detailed view activity using the intent
		mIntent.putExtra(TabViewActivity.ANIMAL_KEY, animalName);
		// Start the new activity
		startActivity(mIntent);
	}
}