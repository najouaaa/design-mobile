package com.example.tabs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
    

      setListAdapter(new ListAdapter(this));

      ListView lv = getListView();
      lv.setTextFilterEnabled(true);
      
    
      lv.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
        	
          // When clicked, show a toast with the TextView text
        	 Intent intent;  // Reusable Intent for each tab
	        	switch(position){
	        	case 0:
	        		LinearActivity.the_id=0;
	        		intent = new Intent().setClass(ListViewActivity.this, LinearActivity.class);
	        		startActivity(intent);
	        	break;
	        	case 1:
	        		LinearActivity.the_id=1;
	        		intent = new Intent().setClass(ListViewActivity.this, LinearActivity.class);
	        		startActivity(intent);
	        	break;
	        	case 2:
	        		LinearActivity.the_id=2;
	        		intent = new Intent().setClass(ListViewActivity.this, LinearActivity.class);
	        		startActivity(intent);
	        	break;
	        	case 3:
	        		LinearActivity.the_id=3;
	        		intent = new Intent().setClass(ListViewActivity.this, LinearActivity.class);
	        		startActivity(intent);
	        	break;
	        	case 4:
	        		LinearActivity.the_id=4;
	        		intent = new Intent().setClass(ListViewActivity.this, LinearActivity.class);
	        		startActivity(intent);
	        	break;
	        	}
        	 
        }
      });
      
    }
    
}