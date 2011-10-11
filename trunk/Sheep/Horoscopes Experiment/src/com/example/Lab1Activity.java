package com.example;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Lab1Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);
		
		Bundle extras = getIntent().getExtras();
		int position = extras.getInt("position");
		Resources res = getResources();
		String[] horo_names = res.getStringArray(R.array.horo_array);
		String[] horo_descriptions = res
				.getStringArray(R.array.horo_description_array);

		TextView titleView = (TextView) findViewById(R.id.title);
		TextView descriptionView = (TextView) findViewById(R.id.description);
		ImageView imageView = (ImageView) findViewById(R.id.image);
		titleView.setText(horo_names[position]);
		descriptionView.setText(horo_descriptions[position]);
		imageView.setImageResource(ImageMapper.findBig(position));
	}
}