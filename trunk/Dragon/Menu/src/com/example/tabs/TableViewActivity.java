package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TableViewActivity extends Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.table);
	    }
	    
	 	public void myClickHandler(View view) {
	 		Intent intent;
	 		switch (view.getId())
	 		{
	 		case R.id.horse:
	 			LinearActivity.the_id=1;
	  			intent = new Intent().setClass(TableViewActivity.this, LinearActivity.class);
	  			startActivity(intent);
	 			break;
	 		case R.id.snake:
	 			LinearActivity.the_id=3;
	  			intent = new Intent().setClass(TableViewActivity.this, LinearActivity.class);
	  			startActivity(intent);
	 			break;
	 		case R.id.dragon:
	 			LinearActivity.the_id=0;
	 			intent = new Intent().setClass(TableViewActivity.this, LinearActivity.class);
	 			startActivity(intent);
	 			break;
	 		case R.id.rabbit:
	 			LinearActivity.the_id=2;
	  			intent = new Intent().setClass(TableViewActivity.this, LinearActivity.class);
	  			startActivity(intent);
	 			break;
	 		case R.id.sheep:
	 			LinearActivity.the_id=4;
	  			intent = new Intent().setClass(TableViewActivity.this, LinearActivity.class);
	  			startActivity(intent);
	 			break;
	 		}
	 	}
}
