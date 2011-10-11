package com.example;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Lab1Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);

		Bundle bundle = this.getIntent().getExtras();
		Resources res = getResources();

		String[] horo_names = res.getStringArray(R.array.horo_array);
		String[] horo_descriptions = res
				.getStringArray(R.array.horo_description_array);

		TextView titleView = (TextView) findViewById(R.id.title);
		TextView descriptionView = (TextView) findViewById(R.id.description);
		ImageView imageView = (ImageView) findViewById(R.id.image);

		titleView.setText(horo_names[bundle.getInt("title_position")]);
		descriptionView.setText(horo_descriptions[bundle
				.getInt("description_position")]);
		imageView.setImageResource(bundle.getInt("image_id"));
	}
}