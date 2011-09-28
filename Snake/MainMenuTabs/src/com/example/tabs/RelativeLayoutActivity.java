package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class RelativeLayoutActivity extends Activity {
    /** Called when the activity is first created. */
	private Button Dragon;
	private Button Rabbit;
	private Button Horse;
	private Button Snake;
	private Button Sheep;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        this.Dragon = (Button)this.findViewById(R.id.dragon);
        this.Rabbit = (Button)this.findViewById(R.id.rabbit);
        this.Horse = (Button)this.findViewById(R.id.horse);
        this.Snake = (Button)this.findViewById(R.id.snake);
        this.Sheep = (Button)this.findViewById(R.id.sheep);
  	  
        this.Dragon.setOnClickListener(new OnClickListener()  {
  	    @Override
  	    public void onClick(View v) {
  	   LinearActivity.the_id=0;
		Intent intent = new Intent().setClass(RelativeLayoutActivity.this, LinearActivity.class);
		startActivity(intent);
  	    }
  	  });
    this.Snake.setOnClickListener(new OnClickListener() {
  	    @Override
  	    public void onClick(View v) {
  	    	LinearActivity.the_id=3;
  			Intent intent = new Intent().setClass(RelativeLayoutActivity.this, LinearActivity.class);
  			startActivity(intent);
  	    }
  	  });
this.Rabbit.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	LinearActivity.the_id=2;
  			Intent intent = new Intent().setClass(RelativeLayoutActivity.this, LinearActivity.class);
  			startActivity(intent);;
	    }
	  });
this.Horse.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	LinearActivity.the_id=1;
  			Intent intent = new Intent().setClass(RelativeLayoutActivity.this, LinearActivity.class);
  			startActivity(intent);
	    }
	  });
this.Sheep.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	LinearActivity.the_id=4;
  			Intent intent = new Intent().setClass(RelativeLayoutActivity.this, LinearActivity.class);
  			startActivity(intent);
	    }
	  });
}
}