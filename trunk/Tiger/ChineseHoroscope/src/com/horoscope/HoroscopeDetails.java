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

		int pos = (getIntent().getIntExtra("pos", 1)) + 1;
		String name = getIntent().getStringExtra("title");

		setContentView(R.layout.linear);
		setImageAndText(pos, name);
	}

	public void setImageAndText(int pos, String title) {
		ImageView horoscope = (ImageView) findViewById(R.id.horoscope_image);
		horoscope.setImageDrawable(getResources().getDrawable(R.drawable.icon));// getResources().getIdentifier("image_"+name,
		// "string","com.horoscope")));

		TextView t = (TextView) findViewById(R.id.title);
		t.setText(title);

		TextView text1 = (TextView) findViewById(R.id.text1);
		text1.setText(getResources().getString(getResources().getIdentifier("a" + pos + "1", "string", "com.horoscope")));

		TextView text2 = (TextView) findViewById(R.id.text2);
		text2.setText(getResources().getString(getResources().getIdentifier("a" + pos + "2", "string", "com.horoscope")));
	}
}