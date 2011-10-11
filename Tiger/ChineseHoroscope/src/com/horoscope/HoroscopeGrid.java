package com.horoscope;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author Gad
 * @author Dalia
 */
public class HoroscopeGrid extends Activity {
	/** Called when the activity is first created. */
	
	GridView gridview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.grid);
		
		//show a progress bar
		AsyncTask<Void, Void, Void> read = new AsyncTask<Void, Void, Void>() {
		    ProgressDialog progress;

		    @Override
		    protected void onPreExecute() {
		    	progress = new ProgressDialog(HoroscopeGrid.this);
		    	progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		        progress.setMessage("Loading. Please wait..."); 
		        progress.setIndeterminate(true);
		        progress.show();
		        super.onPreExecute();
		    }

		    

		    @Override
		    protected void onPostExecute(Void result) {
		        super.onPostExecute(result);
		       

	     		 /*
				 * Adding the grid for the view
				 */
				gridview = (GridView) findViewById(R.id.gridview);
	     		gridview.setAdapter(new ImageAdapter(HoroscopeGrid.this));
	     	

	     		gridview.setOnItemClickListener(new OnItemClickListener() {
	     			@Override
	     			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	     				
	     				/*
	     				 * Link auto-complete textbox to list of horoscopes
	     				 */
	     				
	     				Intent i = new Intent(HoroscopeGrid.this, HoroscopeDetails.class);
	     				i.putExtra("pos", position%12);
	     				i.putExtra("title", ((String)((TextView)v).getTag()).toString());
	     				startActivity(i);
	     				
	     			}
	     		});
		      
	     		//hide bar when done
	     		progress.dismiss();
	     		
	     		
		    }



			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub

				return null;
			}
		};
		read.execute();
		
	
		
		
	}
	
}