package com.horoscope;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author Dina
 */
public class HoroscopesList extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] horoscopes = getResources().getStringArray(R.array.horoscope_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, horoscopes));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
				i.putExtra("pos", position);
				i.putExtra("title", ((TextView) view).getText());
				startActivity(i);
			}
		});
	}
}