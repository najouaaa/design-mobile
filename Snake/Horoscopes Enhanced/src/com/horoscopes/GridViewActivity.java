package com.horoscopes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.horoscopes.R;

public class GridViewActivity extends Activity {

	private ProgressBar progressBar;
	private Handler handler = new Handler();
	private int count = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view);
		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		final GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				int nameId = 0;
				int descriptionId = 0;
				int imageId = 0;
				switch (position) {

				case 0:
					nameId = R.string.horse;
					descriptionId = R.string.horse_desc;
					imageId = R.drawable.horse;
					break;
				case 1:
					nameId = R.string.tiger;
					descriptionId = R.string.tiger_desc;
					imageId = R.drawable.tiger;
					break;
				case 2:
					nameId = R.string.rabbit;
					descriptionId = R.string.rabbit_desc;
					imageId = R.drawable.rabbit;
					break;
				case 3:
					nameId = R.string.sheep;
					descriptionId = R.string.sheep_desc;
					imageId = R.drawable.sheep;
					break;
				case 4:
					nameId = R.string.snake;
					descriptionId = R.string.snake_desc;
					imageId = R.drawable.snake;
					break;
				}
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				b.putInt("position", position);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});

		new Thread(new Runnable() {
			public void run() {
				while (count < 100) {
					count ++;
					try {
						Thread.sleep(10);
					} catch (Throwable t) {
					}
					handler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(count);
							if (count >= 100) {
								progressBar.setVisibility(View.INVISIBLE);
								gridView.setVisibility(View.VISIBLE);
								return;
							}
						}
					});
				}

			}
		}).start();

	}
}