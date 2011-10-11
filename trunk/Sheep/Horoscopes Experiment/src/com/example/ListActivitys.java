package com.example;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListActivitys extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        setListAdapter(new CustomAdapter(this));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      // TODO Auto-generated method stub
      super.onListItemClick(l, v, position, id);
      Intent i = new Intent(ListActivitys.this, LinearLayouts.class);

		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
		i.putExtras(bundle);
		startActivity(i);
    }
}