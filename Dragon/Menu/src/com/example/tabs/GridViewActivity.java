package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ProgressBar;

public class GridViewActivity extends Activity {
    /** Called when the activity is first created. */
	private Handler mHandler = new Handler();
    private boolean isUpdateRequired=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 	super.onCreate(savedInstanceState);
    	    
    	 	setContentView(R.layout.grid);
    	 	
            GridView gridview = (GridView) findViewById(R.id.gridview);
    	    
            progressBarHandler();
           
    	    gridview.setAdapter(new ImageAdapter(this)); 	   
       	    gridview.setOnItemClickListener(new OnItemClickListener() {
    	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
    	        	 Intent intent;
    	        		TableActivity.the_id=position;
    	        		intent = new Intent().setClass(GridViewActivity.this, TableActivity.class);        
    	        		startActivity(intent);
    	        }
    	    });
    	    gridview=null;
            isUpdateRequired=true;
    }
    public void progressBarHandler(){
    	try{
	    	new Thread(new Runnable() {
	    		public void run() {
	    			while(!isUpdateRequired);
                	android.os.SystemClock.sleep(1000);   
            	    
                	mHandler.post(new Runnable() {
                        public void run() {
                       	 ((ProgressBar) findViewById(R.id.ProgressBar)).setVisibility(View.GONE);
                     	((GridView) findViewById(R.id.gridview)).setVisibility(View.VISIBLE);
                        }
            	    }); 	
	    		
	    		
	    		}
	    	}).start();
	        
	    }catch (Exception e) {
	    	
	    }
    }
}