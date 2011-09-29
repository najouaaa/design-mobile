package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeActivity extends Activity {
    
	protected static final String alert = null;
	Button sheep, rabbit, snake, horse;
	int id;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
		setContentView(R.layout.relative_layout);
		
		sheep = (Button) findViewById(R.id.sheep);
		rabbit = (Button) findViewById(R.id.rabbit);
		snake = (Button) findViewById(R.id.snake);
		horse = (Button) findViewById(R.id.horse);
		
		
		sheep.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

			Toast.makeText(getApplicationContext(),
					((Button) sheep).getText().toString() , 
					Toast.LENGTH_SHORT).show();
				Intent i = new Intent(RelativeActivity.this, LinearLayouts.class);
	    		Bundle bundle = new Bundle();
	    		bundle.putString("param1", ((Button) sheep).getText().toString());
	    		i.putExtras(bundle);
				startActivity(i);
				
		
			}
		});
		
		rabbit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
			
				Toast.makeText(getApplicationContext(),
						((Button) rabbit).getText().toString() , 
						Toast.LENGTH_SHORT).show();
				Intent i = new Intent(RelativeActivity.this, LinearLayouts.class);
	    		Bundle bundle = new Bundle();
	    		bundle.putString("param1", ((Button) rabbit).getText().toString());
	    		i.putExtras(bundle);
				startActivity(i);
				
			
			}
		});
		
		snake.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Toast.makeText(getApplicationContext(),
						((Button) snake).getText().toString() , 
						Toast.LENGTH_SHORT).show();
				Intent i = new Intent(RelativeActivity.this, LinearLayouts.class);
	    		Bundle bundle = new Bundle();
	    		bundle.putString("param1", ((Button) snake).getText().toString());
	    		i.putExtras(bundle);
				startActivity(i);
				
				
			}
		});
		
		horse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Toast.makeText(getApplicationContext(),
						((Button) horse).getText().toString() , 
						Toast.LENGTH_SHORT).show();
				Intent i = new Intent(RelativeActivity.this, LinearLayouts.class);
	    		Bundle bundle = new Bundle();
	    		bundle.putString("param1", ((Button) horse).getText().toString());
	    		i.putExtras(bundle);
				startActivity(i);
				
			}
		});

    }
}