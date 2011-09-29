package com.horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Dalia El Badawi
 **/
public class HoroscopeDetails extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int pos = (getIntent().getIntExtra("pos", 1)) + 1; //position of item in list
		String name = getIntent().getStringExtra("title"); //text of item

		setContentView(R.layout.linear);
		setImageAndText(pos, name);
	}

	/***
	 * Called when going to the details view (linear view)
	 * 
	 * @param pos
	 * @param title
	 */
	public void setImageAndText(int pos, String title) {
		//horoscope image
		ImageView horoscope = (ImageView) findViewById(R.id.horoscope_image);
		horoscope.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(title.toLowerCase()+"_zodiac","drawable","com.horoscope")));
		//name of horoscope
		TextView t = (TextView) findViewById(R.id.title);
		t.setText(title);
		
		//first part of description, id is a+position of item in list+1
		TextView text1 = (TextView) findViewById(R.id.text1);
		text1.setText(getResources().getString(getResources().getIdentifier("a" + pos + "1", "string", "com.horoscope")));
		
		//second part of description id is a+position of item in list+2
		TextView text2 = (TextView) findViewById(R.id.text2);
		text2.setText(getResources().getString(getResources().getIdentifier("a" + pos + "2", "string", "com.horoscope")));
	}
}