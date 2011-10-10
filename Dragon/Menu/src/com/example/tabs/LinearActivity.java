package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LinearActivity extends Activity implements View.OnClickListener {
	// defining handler classes as a private inner class

	public static int the_id=0;
	TextView content1 ;
	TextView content2 ;
	ImageView myImg;
	Button button1;
	Button button2;
	/** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);
		 content1 = (TextView)findViewById(R.id.txt1);
		 content2 = (TextView)findViewById(R.id.txt2);
		 myImg = (ImageView)findViewById(R.id.img);
		 button1 =(Button)findViewById(R.id.first_button);
		 button2 =(Button)findViewById(R.id.second_button);
		 button1.setClickable(true);
	     button2.setClickable(true);
	     button1.setOnClickListener(this);
         button2.setOnClickListener(this);
        switch(the_id)
        {
        	case 1:
        		content1.setText(R.string.HorseName);
        		content2.setText(R.string.HorseDescription);
        		myImg.setImageResource(R.drawable.horse);
        	break;
        	case 0:
        		content1.setText(R.string.DragonName);
        		content2.setText(R.string.DragonDescription);
        		myImg.setImageResource(R.drawable.dragon);
        	break;
        	case 3:
        		content1.setText(R.string.SnakeName);
        		content2.setText(R.string.SnakeDescription);
        		myImg.setImageResource(R.drawable.snake);
        	break;
        	case 4:
        		content1.setText(R.string.SheepName);
        		content2.setText(R.string.SheepDescription);
        		myImg.setImageResource(R.drawable.sheep);
        	break;
        	case 2:
        		content1.setText(R.string.RabbitName);
        		content2.setText(R.string.RabbitDescription);
        		myImg.setImageResource(R.drawable.rabbit);
        	break;
        }
    
       
		
	}
	public void onClick(View v) {
		if(button1.isPressed())
		{
		the_id--;
		if(the_id<0)
			the_id=4;}
		else if(button2.isPressed())
		{
			the_id++;
			if(the_id>4)
				the_id=0;
		}
		switch(the_id)
        {
        	case 1:
        		content1.setText(R.string.HorseName);
        		content2.setText(R.string.HorseDescription);
        		myImg.setImageResource(R.drawable.horse);
        	break;
        	case 0:
        		content1.setText(R.string.DragonName);
        		content2.setText(R.string.DragonDescription);
        		myImg.setImageResource(R.drawable.dragon);
        	break;
        	case 3:
        		content1.setText(R.string.SnakeName);
        		content2.setText(R.string.SnakeDescription);
        		myImg.setImageResource(R.drawable.snake);
        	break;
        	case 4:
        		content1.setText(R.string.SheepName);
        		content2.setText(R.string.SheepDescription);
        		myImg.setImageResource(R.drawable.sheep);
        	break;
        	case 2:
        		content1.setText(R.string.RabbitName);
        		content2.setText(R.string.RabbitDescription);
        		myImg.setImageResource(R.drawable.rabbit);
        	break;
        }

	}

	    
	  
}
	