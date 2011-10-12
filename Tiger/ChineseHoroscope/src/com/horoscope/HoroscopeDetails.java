package com.horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.ViewStub;

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
		setButtonVisibilty(pos);
		
		setRating(pos);
		viewListOfFriends(pos);
		
	}

	private void viewListOfFriends(int pos) {
			
		String[]names=getResources().getStringArray(getResources().getIdentifier("l"+pos, "array", "com.horoscope"));
		if(names.length>1)
		{	
		ViewStub stub = (ViewStub) findViewById(R.id.firends_stub);
	    TextView inflatedList=(TextView)stub.inflate();
	    inflatedList.setText("Friends in this Horoscope:\n"+listToString(names));
		}
	    
		
	}
	private static String listToString(String []ar){
		String s="";
		for (int i = 0; i < ar.length; i++) {
			s+=("\n"+ar[i]);
		}
		return s;
	}

	/**
	 * to set the rate value from ratings saved in strings.xml
	 * 
	 * @author Gad
	 * @param pos
	 */
	private void setRating(int pos) {
		// set the rating value according to ratings saved in strings.xml
		RatingBar rt=(RatingBar) findViewById(R.id.detailstar);
		String[]ratings=getResources().getStringArray(R.array.ratings);
		rt.setRating(Float.parseFloat(ratings[pos]));
		
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
	 * @param pos
	 */
	public void setButtonVisibilty(int pos) {
		if (pos != 0 && pos != (horoscopes.length - 1)) {
			findViewById(R.id.nextButton).setVisibility(
					android.view.View.VISIBLE);
			findViewById(R.id.prevButton).setVisibility(
					android.view.View.VISIBLE);
		} else {
			if (pos == 0) {
				findViewById(R.id.prevButton).setVisibility(
						android.view.View.INVISIBLE);
			} else {
				findViewById(R.id.nextButton).setVisibility(
						android.view.View.INVISIBLE);
			}
		}
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
		setButtonVisibilty(pos);
		// by Gad
		setRating(pos);
		viewListOfFriends(pos);
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
		setButtonVisibilty(pos);
		//by Gad
		setRating(pos);
		viewListOfFriends(pos);

	}
	
	
	
}