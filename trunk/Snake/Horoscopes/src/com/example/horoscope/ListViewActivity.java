package com.example.horoscope;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] horoscopes = getResources().getStringArray(
				R.array.horoscope_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				horoscopes));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
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
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});
	}
}
