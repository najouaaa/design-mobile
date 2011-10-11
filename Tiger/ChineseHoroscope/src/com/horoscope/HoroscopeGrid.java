package com.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author Gad
 * @author Dalia
 */
public class HoroscopeGrid extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.grid_progress);
		//the progress bar
		ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progressbar1);
		
		
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
		//display gridview
		gridview.setVisibility(View.VISIBLE);
		
       
	}
	
}