package com.example;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class LinearLayouts extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linearlayout);

		Bundle bundle = getIntent().getExtras();

		TextView titleView = (TextView) findViewById(R.id.title);
		TextView descriptionView = (TextView) findViewById(R.id.description);
		Resources res = getResources();
		
		String[] horo_names = res.getStringArray(R.array.horo_array);
		String[] horo_descriptions = res
				.getStringArray(R.array.horo_description_array);
		
		titleView.setText(horo_names[bundle.getInt("position")]);
		descriptionView.setText(horo_descriptions[bundle.getInt("position")]);
	}

}