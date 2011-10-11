package com.example.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeLayoutActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);

		final Button buttonHorse = (Button) findViewById(R.id.horse_button);
		buttonHorse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int nameId = R.string.horse;
				int descriptionId = R.string.horse_desc;
				int imageId = R.drawable.horse;
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

		final Button buttonSheep = (Button) findViewById(R.id.sheep_button);
		buttonSheep.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int nameId = R.string.sheep;
				int descriptionId = R.string.sheep_desc;
				int imageId = R.drawable.sheep;
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

		final Button buttonRabbit = (Button) findViewById(R.id.rabbit_button);
		buttonRabbit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int nameId = R.string.rabbit;
				int descriptionId = R.string.rabbit_desc;
				int imageId = R.drawable.rabbit;
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

		final Button buttonSnake = (Button) findViewById(R.id.snake_button);
		buttonSnake.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int nameId = R.string.snake;
				int descriptionId = R.string.snake_desc;
				int imageId = R.drawable.snake;
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

		final Button button = (Button) findViewById(R.id.tiger_button);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int nameId = R.string.tiger;
				int descriptionId = R.string.tiger_desc;
				int imageId = R.drawable.tiger;
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

	}
}
