package com.example.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TableLayoutActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);
	}

	public void onHoroscopeClick(View v) {
		int nameId = 0;
		int descriptionId = 0;
		int imageId = 0;
		switch (v.getId()) {
		case R.id.sheep_row:
			nameId = R.string.sheep;
			descriptionId = R.string.sheep_desc;
			imageId = R.drawable.sheep;
			break;
		case R.id.horse_row:
			nameId = R.string.horse;
			descriptionId = R.string.horse_desc;
			imageId = R.drawable.horse;
			break;
		case R.id.rabbit_row:
			nameId = R.string.rabbit;
			descriptionId = R.string.rabbit_desc;
			imageId = R.drawable.rabbit;
			break;
		case R.id.snake_row:
			nameId = R.string.snake;
			descriptionId = R.string.snake_desc;
			imageId = R.drawable.snake;
			break;
		case R.id.tiger_row:
			nameId = R.string.tiger;
			descriptionId = R.string.tiger_desc;
			imageId = R.drawable.tiger;
			break;
		}
		Bundle b = new Bundle();
		b.putInt("name_id", nameId);
		b.putInt("desc_id", descriptionId);
		b.putInt("image_id", imageId);
		Intent detailsIntent = new Intent(this, LinearLayoutActivity.class);
		detailsIntent.putExtras(b);
		startActivity(detailsIntent);
	}
}