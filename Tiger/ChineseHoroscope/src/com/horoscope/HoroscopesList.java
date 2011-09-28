package com.horoscope;

import com.example.hellolistview.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.*;

public class HoroscopesList extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

    	String[] countries = getResources().getStringArray(R.array.countries_array);
    	setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, countries));
    	
    	  ListView lv = getListView();
    	  lv.setTextFilterEnabled(true);

    	  lv.setOnItemClickListener(new OnItemClickListener() {
    	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    	    	 switch(position) {
    	    	 case 0:
    	    		 Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
    	    		 i.putExtra("text", R.string.horse1);
    	    		 i.putExtra("text2", R.string.horse2);
    	    		 startActivity(i);
    	    	    }	
    	    }
    	  });
    }
}