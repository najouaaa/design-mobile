package com.example;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class RelativeActivity extends Activity   {
    
	protected static final String alert = null;
	int id;
	

    protected int mPos;
    protected String mSelection;
    
    ViewStub stub;
    View inflated;
    Spinner spinner;
    ScrollView mScroller;

    /**
     * ArrayAdapter connects the spinner widget to array-based data.
     */
    protected ArrayAdapter<CharSequence> mAdapter;

    	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
		setContentView(R.layout.relative_layout);
 
		 spinner = (Spinner) findViewById(R.id.Spinner01);
		this.mAdapter = ArrayAdapter.createFromResource(this, 
						R.array.horo_array, android.R.layout.simple_spinner_dropdown_item);
		

        spinner.setAdapter(mAdapter);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener(this,this.mAdapter);
        spinner.setOnItemSelectedListener(spinnerListener);
        spinner.setPrompt("Choose a horoscope");
        
        
        mScroller = (ScrollView) findViewById(R.id.ScrollView01);
        mScroller.setMinimumHeight(150);
       
        
 	    stub = (ViewStub) findViewById(R.id.stub);
 	    inflated = stub.inflate();

    }
	
	
	 /**
     *  A callback listener that implements the
     *  {@link android.widget.AdapterView.OnItemSelectedListener} interface
     *  For views based on adapters, this interface defines the methods available
     *  when the user selects an item from the View.
     *
     */
    public class myOnItemSelectedListener implements OnItemSelectedListener {

        /*
         * provide local instances of the mLocalAdapter and the mLocalContext
         */

        ArrayAdapter<CharSequence> mLocalAdapter;
        Activity mLocalContext;

        /**
         *  Constructor
         *  @param c - The activity that displays the Spinner.
         *  @param ad - The Adapter view that
         *    controls the Spinner.
         *  Instantiate a new listener object.
         */
        public myOnItemSelectedListener(Activity c, ArrayAdapter<CharSequence> ad) {

          this.mLocalContext = c;
          this.mLocalAdapter = ad;

        }

        /**
         * When the user selects an item in the spinner, this method is invoked by the callback
         * chain. Android calls the item selected listener for the spinner, which invokes the
         * onItemSelected method.
         *
         * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(
         *  android.widget.AdapterView, android.view.View, int, long)
         * @param parent - the AdapterView for this listener
         * @param v - the View for this listener
         * @param pos - the 0-based position of the selection in the mLocalAdapter
         * @param row - the 0-based row number of the selection in the View
         */
        public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {

            // RelativeActivity.this.mPos = pos;
            RelativeActivity.this.mSelection = parent.getItemAtPosition(pos).toString();
            /*
             * Set the value of the text field in the UI
             */
            
           if(RelativeActivity.this.mPos != pos)
           {
  
            TextView des = (TextView) inflated.findViewById(R.id.description);
            TextView title = (TextView) inflated.findViewById(R.id.title);

            title.setText(RelativeActivity.this.mSelection);
            
            int num = 0;
            if(title.getText().toString().equalsIgnoreCase("Sheep"))
            	num = R.array.goat_array;
            else if(title.getText().toString().equalsIgnoreCase("Horse"))
            	num = R.array.horse_array;
            else if(title.getText().toString().equalsIgnoreCase("Snake"))
            	num = R.array.snake_array;
            else if(title.getText().toString().equalsIgnoreCase("Rabbit"))
            	num = R.array.rabbit_array;

    		Resources res = getResources();
    		String[] horse = res.getStringArray(num);
    		
            des.setText(horse[1]);
            
           } 
           
           RelativeActivity.this.mPos = pos;
        }

        
 
        /**
         * The definition of OnItemSelectedListener requires an override
         * of onNothingSelected(), even though this implementation does not use it.
         * @param parent - The View for this Listener
         */
        public void onNothingSelected(AdapterView<?> parent) {

            // do nothing

        }
    }

	
}

