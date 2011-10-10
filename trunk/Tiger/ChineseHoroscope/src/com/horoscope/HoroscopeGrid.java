package com.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author Gad
 */
public class HoroscopeGrid extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.grid_progress);//grid);
		ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progressbar1);
		//progressHorizontal.setVisibility(View.VISIBLE);
		
		/*
		 * Adding the grid for the view
		 */
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
	

		gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				
				/*
				 * Link auto-complete textbox to list of horoscopes
				 */
				
				Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
				i.putExtra("pos", position%12);
				i.putExtra("title", ((String)((TextView)v).getTag()).toString());
				startActivity(i);
				
			}
		});
		//hide bar when done
		progressHorizontal.setVisibility(View.INVISIBLE);
		gridview.setVisibility(View.VISIBLE);
		
       
	}
	
}