package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ArtistsActivity extends Activity {
    /** Called when the activity is first created. */
	
	 private ProgressBar mProgress;
     private int mProgressStatus = 0;

     private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);
       final GridView gridview = (GridView) findViewById(R.id.gridview);
       final TextView textview = (TextView) findViewById(R.id.loading);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setVisibility(View.INVISIBLE);
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	Intent i = new Intent(ArtistsActivity.this, Lab1Activity.class);
	    		Bundle bundle = new Bundle();
            	if(position==0)
            		bundle.putString("param1", "Rabbit");
            	if(position==1)
            		bundle.putString("param1", "Horse");
            	if(position==2)
            		bundle.putString("param1", "Sheep");
            	if(position==3)
            		bundle.putString("param1", "Snake");
            	i.putExtras(bundle);
	    		startActivity(i);
            }
        });
    
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    try{
                       
                        Thread.sleep(100);
                       }
                       catch(Throwable t){
                       }
                    System.out.println("here");
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                            if(mProgressStatus >= 100){
                            	mProgress.setVisibility(View.INVISIBLE);
                            	textview.setVisibility(View.INVISIBLE);
                            	gridview.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
              
             
             
            }
        }).start();
        
        }
}