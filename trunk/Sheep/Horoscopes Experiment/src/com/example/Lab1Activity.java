package com.example;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class Lab1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getIntent().getExtras();
		String input = bundle.getString("param1");
        int id = 0;
        if (input.equals("Horse") )
			id = R.array.horse_array;
		else if (input.equals("Rabbit"))
			id = R.array.rabbit_array;
		else if (input.equals("Sheep"))
			id = R.array.goat_array;
		else if (input.equals("Snake"))
			id = R.array.snake_array;
		Resources res = getResources();
		String[] horoscope = res.getStringArray(id);
        
        setContentView(R.layout.table_layout);
        TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        titleView.setText(horoscope[0]);
        descriptionView.setText(horoscope[1]);
    }
}