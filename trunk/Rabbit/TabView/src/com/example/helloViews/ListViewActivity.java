package com.example.helloViews;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ListActivity;
import android.content.Intent;

public class ListViewActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       listView();
    }
    
public void listView(){
   
	setListAdapter(new ArrayAdapter<String>(this, R.layout.list_view, HOROSCOPES));
   	ListView lv = getListView();
   	lv.setTextFilterEnabled(true);    	
   	lv.setOnItemClickListener(new OnItemClickListener() {
   		 public void onItemClick(AdapterView<?> parent, View view,
   				 int position, long id) {
   		   	
   			 // Generate intent to move between activities
   			 Intent mIntent = new Intent(getApplicationContext(),HoroscopeInfoActivity.class); 
   			 // Pass variable to detailed view activity using the intent
   			 mIntent.putExtra(TabViewActivity.ANIMAL_KEY, HOROSCOPES[position].toLowerCase());
   			 // Start the new activity
   			 startActivity(mIntent);
   					 	
		}// end onItemClick
   	});
}// end listView
   
    static final String[] HOROSCOPES = new String[] {
    	"Rat", "Ox", "Tiger", "Rabbit", "Dragon"};
    
}