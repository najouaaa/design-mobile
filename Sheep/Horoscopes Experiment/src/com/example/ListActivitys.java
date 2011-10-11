package com.example;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivitys extends ListActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] horos = getResources().getStringArray(R.array.horo_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, horos));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent i = new Intent(ListActivitys.this, LinearLayouts.class);

				Bundle bundle = new Bundle();
				bundle.putInt("position", position);
				i.putExtras(bundle);
				startActivity(i);
			}
		});
	}

}