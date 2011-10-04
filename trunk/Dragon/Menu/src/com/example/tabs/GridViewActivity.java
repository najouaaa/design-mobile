package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class GridViewActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	    setContentView(R.layout.grid);

    	    GridView gridview = (GridView) findViewById(R.id.gridview);
    	    gridview.setAdapter(new ImageAdapter(this));

    	    gridview.setOnItemClickListener(new OnItemClickListener() {
    	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
    	        	 Intent intent;  // Reusable Intent for each tab
    	        	switch(position){
    	        	case 0:
    	        		LinearActivity.the_id=0;
    	        		intent = new Intent().setClass(GridViewActivity.this, LinearActivity.class);
    	        		startActivity(intent);
    	        	break;
    	        	case 1:
    	        		LinearActivity.the_id=1;
    	        		intent = new Intent().setClass(GridViewActivity.this, LinearActivity.class);
    	        		startActivity(intent);
    	        	break;
    	        	case 2:
    	        		LinearActivity.the_id=2;
    	        		intent = new Intent().setClass(GridViewActivity.this, LinearActivity.class);
    	        		startActivity(intent);
    	        	break;
    	        	case 3:
    	        		LinearActivity.the_id=3;
    	        		intent = new Intent().setClass(GridViewActivity.this, LinearActivity.class);
    	        		startActivity(intent);
    	        	break;
    	        	case 4:
    	        		LinearActivity.the_id=4;
    	        		intent = new Intent().setClass(GridViewActivity.this, LinearActivity.class);
    	        		startActivity(intent);
    	        	break;
    	        	}
    	            
    	        }
    	    });
    }
}