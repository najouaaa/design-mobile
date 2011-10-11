package com.example;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ArtistsActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent i = new Intent(getApplicationContext(),
						Lab1Activity.class);

				int imageID = 0;

				Resources res = getResources();
				String[] horoscope = res.getStringArray(R.array.horo_array);

				Bundle bundle = new Bundle();

				switch (position) {
				case 0:
					imageID = R.drawable.horse_big;
					break;
				case 1:
					imageID = R.drawable.sheep_big;
					break;
				case 2:
					imageID = R.drawable.snake_big;
					break;
				case 3:
					imageID = R.drawable.rabbit_big;
					break;
				default:
					break;
				}

				bundle.putInt("position", position);
				bundle.putInt("image_id", imageID);
				i.putExtras(bundle);
				startActivity(i);
			}
		});
	}
}