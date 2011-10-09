package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TableActivity extends Activity {
public static int the_id=0;
	
	/** Called when the activity is first created. */
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		TextView content2 = (TextView)findViewById(R.id.txt2);
		ImageView myImg = (ImageView)findViewById(R.id.img);

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
