package com.example;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class LinearLayouts extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linearlayout);

		Bundle bundle = getIntent().getExtras();

		final int position = bundle.getInt("position");
		float rating = (float) bundle.getDouble("rating");

		TextView titleView = (TextView) findViewById(R.id.title);
		TextView descriptionView = (TextView) findViewById(R.id.description);
		ImageView imageView = (ImageView) findViewById(R.id.image);
		RatingBar ratingBar = (RatingBar) findViewById(R.id.rateLinear);

		Resources res = getResources();

		String[] horo_names = res.getStringArray(R.array.horo_array);
		String[] horo_descriptions = res
				.getStringArray(R.array.horo_description_array);
		String[] horo_friends = res.getStringArray(R.array.horo_friends);

		titleView.setText(horo_names[position]);
		descriptionView.setText(horo_descriptions[position]);
		imageView.setImageResource(ImageMapper.findBig(position));
		ratingBar.setRating(rating);
		ViewStub stub = (ViewStub) findViewById(R.id.stub);
		TextView inflated = (TextView) stub.inflate();
		inflated.setText("Friends : " + horo_friends[position]);
		final Button next = (Button) findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(),
						LinearLayouts.class);
				int newPosition = (position >= 3) ? 0 : position + 1;
				intent.putExtra("position", newPosition);
				startActivity(intent);
			}
		});

		final Button back = (Button) findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(),
						LinearLayouts.class);
				int newPosition = (position <= 0) ? 3 : position - 1;
				intent.putExtra("position", newPosition);
				startActivity(intent);
			}
		});
	}

}