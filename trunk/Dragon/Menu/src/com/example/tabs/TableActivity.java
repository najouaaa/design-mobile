package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TableActivity extends Activity implements View.OnClickListener {
public static int the_id=0;
	
	/** Called when the activity is first created. */
	TextView content2;
	ImageView myImg;
	Button button1;
	Button button2;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		content2 = (TextView)findViewById(R.id.txt2);
		myImg = (ImageView)findViewById(R.id.img);
		button1 =(Button)findViewById(R.id.button_one);
		 button2 =(Button)findViewById(R.id.button_two);
		 button1.setClickable(true);
	     button2.setClickable(true);
	     button1.setOnClickListener(this);
	     button2.setOnClickListener(this);

        switch(the_id)
        {
        	case 1:
        		content2.setText(R.string.HorseDescription);
        		myImg.setImageResource(R.drawable.horse);
        	break;
        	case 0:
        		content2.setText(R.string.DragonDescription);
        		myImg.setImageResource(R.drawable.dragon);
        	break;
        	case 3:
        		content2.setText(R.string.SnakeDescription);
        		myImg.setImageResource(R.drawable.snake);
        	break;
        	case 4:
           		content2.setText(R.string.SheepDescription);
        		myImg.setImageResource(R.drawable.sheep);
        	break;
        	case 2:
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
    		content2.setText(R.string.HorseDescription);
    		myImg.setImageResource(R.drawable.horse);
    	break;
    	case 0:
    		content2.setText(R.string.DragonDescription);
    		myImg.setImageResource(R.drawable.dragon);
    	break;
    	case 3:
    		content2.setText(R.string.SnakeDescription);
    		myImg.setImageResource(R.drawable.snake);
    	break;
    	case 4:
       		content2.setText(R.string.SheepDescription);
    		myImg.setImageResource(R.drawable.sheep);
    	break;
    	case 2:
    		content2.setText(R.string.RabbitDescription);
    		myImg.setImageResource(R.drawable.rabbit);
    	break;
        }

		
	}
}
