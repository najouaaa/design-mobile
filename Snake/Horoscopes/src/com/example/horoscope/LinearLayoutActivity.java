package com.example.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LinearLayoutActivity extends Activity {
	/** Called when the activity is first created. */

	int position;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);

		ImageView imageView = (ImageView) findViewById(R.id.horoscope_image);
		TextView titleTextView = (TextView) findViewById(R.id.horoscope_title_textview);
		TextView descriptionTextView = (TextView) findViewById(R.id.horoscope_desc_textview);

		Bundle b = getIntent().getExtras();

		int nameId = b.getInt("name_id");
		titleTextView.setText(nameId);

		int descriptionId = b.getInt("desc_id");
		descriptionTextView.setText(descriptionId);

		int imageId = b.getInt("image_id");
		imageView.setImageResource(imageId);
	}
}