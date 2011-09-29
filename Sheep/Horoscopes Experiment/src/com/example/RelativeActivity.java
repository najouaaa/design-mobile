package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("7as7as")
		    .setCancelable(false)
		    .setTitle("Sheep")
		    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int id) {
		        dialog.dismiss();
		        }
		    });
		final AlertDialog alert = builder.create();
		
		
		sheep.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
		
				id = R.array.goat_array;
				Resources res = getResources();
				String[] horse = res.getStringArray(id);
				setContentView(R.layout.linearlayout);
				TextView titleView = (TextView) findViewById(R.id.title);
				TextView descriptionView = (TextView) findViewById(R.id.description);
				titleView.setText("Sheep");
				descriptionView.setText(horse[1]);
				
		
			}
		});
		
		rabbit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
			
				id = R.array.rabbit_array;
				Resources res = getResources();
				String[] horse = res.getStringArray(id);
				setContentView(R.layout.linearlayout);
				TextView titleView = (TextView) findViewById(R.id.title);
				TextView descriptionView = (TextView) findViewById(R.id.description);
				titleView.setText("Rabbit");
				descriptionView.setText(horse[1]);
			
			}
		});
		
		snake.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				
				id = R.array.snake_array;
				Resources res = getResources();
				String[] horse = res.getStringArray(id);
				setContentView(R.layout.linearlayout);
				TextView titleView = (TextView) findViewById(R.id.title);
				TextView descriptionView = (TextView) findViewById(R.id.description);
				titleView.setText("Snake");
				descriptionView.setText(horse[1]);
				
			}
		});
		
		horse.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				
				id = R.array.horse_array;
				Resources res = getResources();
				String[] horse = res.getStringArray(id);
				setContentView(R.layout.linearlayout);
				TextView titleView = (TextView) findViewById(R.id.title);
				TextView descriptionView = (TextView) findViewById(R.id.description);
				titleView.setText("Horse");
				descriptionView.setText(horse[1]);
				
			}
		});

    }
}