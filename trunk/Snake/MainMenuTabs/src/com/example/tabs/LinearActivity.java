package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

public class LinearActivity extends Activity {
	
	public static int the_id=0;
	
	/** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);
		TextView content1 = (TextView)findViewById(R.id.txt1);
		TextView content2 = (TextView)findViewById(R.id.txt2);
		ImageView myImg = (ImageView)findViewById(R.id.img);

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