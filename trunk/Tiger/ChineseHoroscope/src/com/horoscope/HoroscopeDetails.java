package com.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Dalia El Badawi
 **/
public class HoroscopeDetails extends Activity {
	/** Called when the activity is first created. */

	int nextCount;
	String[] horoscopes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		nextCount = 0;
		horoscopes = getResources().getStringArray(R.array.horoscope_array);
		int pos = (getIntent().getIntExtra("pos", 0)); // position of item
		// in list
		String name = getIntent().getStringExtra("title"); // text of item

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
		// horoscope image
		ImageView horoscope = (ImageView) findViewById(R.id.horoscope_image);
		horoscope.setImageDrawable(getResources().getDrawable(
				getResources().getIdentifier(title.toLowerCase() + "_zodiac",
						"drawable", "com.horoscope")));
		// name of horoscope
		TextView t = (TextView) findViewById(R.id.title);
		t.setText(title);

		// first part of description, id is a+position of item in list+1
		TextView text1 = (TextView) findViewById(R.id.text1);
		text1.setText(getResources().getString(
				getResources().getIdentifier("a" + pos + "1", "string",
						"com.horoscope")));

		// second part of description id is a+position of item in list+2
		TextView text2 = (TextView) findViewById(R.id.text2);
		text2.setText(getResources().getString(
				getResources().getIdentifier("a" + pos + "2", "string",
						"com.horoscope")));
	}

	/**
	 * @author Rana
	 * 
	 * @param view
	 */
	public void showNextHoroscope(View view) {
		nextCount++;
		int pos = (getIntent().getIntExtra("pos", 0)) + nextCount; // position
																	// of item

		
		String name = horoscopes[pos]; // Since next count starts by 1
		setContentView(R.layout.linear);
		setImageAndText(pos, name);
		if (pos == (horoscopes.length - 1)) {
			findViewById(R.id.nextButton).setVisibility(
					android.view.View.INVISIBLE);
		}else
		{
			findViewById(R.id.nextButton).setVisibility(android.view.View.VISIBLE);
		}
	}

	/**
	 * @author Rana
	 * @param view
	 */
	public void showPrevHoroscope(View view) {
		nextCount--;
		int pos = (getIntent().getIntExtra("pos", 0)) + nextCount; // position
																	// of item

		
		String name = horoscopes[pos]; // Since next count starts by 1
		setContentView(R.layout.linear);
		setImageAndText(pos, name);
		if (pos == 0) {
			findViewById(R.id.prevButton).setVisibility(
					android.view.View.INVISIBLE);
		}
		else
		{
			findViewById(R.id.prevButton).setVisibility(android.view.View.VISIBLE);
		}

	}
}