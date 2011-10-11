package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HoroscopeInfoActivity extends Activity {
    /** Called when the activity is first created. */
    int ids[]; 
    static int currentIndex; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        initIDs();
        // Get the intent to retrieve input between different activities
        Bundle extras = getIntent().getExtras();
        String animalValue="";
        if(extras !=null) {
            animalValue = extras.getString(TabViewActivity.ANIMAL_KEY);
        }// end if: extract info sent by the intent
        this.setCurrentIndex(animalValue);     
        this.setAnimal(animalValue);        
        
    }// end onCreate
    
    public void initIDs() {
    	ids = new int [5];
    	ids[0] = R.string.h_rabbit;
    	ids[1] = R.string.h_dragon;
    	ids[2] = R.string.h_ox;
    	ids[3] = R.string.h_rat;
    	ids[4] = R.string.h_tiger;		
    }
    
    public void setCurrentIndex(String element) {
    	for(int i = 0; i <= 4; i++) {
    		String temp = getString(ids[i]);
    		if(temp.equalsIgnoreCase(element)) {
    			currentIndex = i; 
    		}
    	}
    }
    
	public void onClickButton(View v) {
		Button b = (Button) v;
		// Generate intent to move between activities
		Intent mIntent = new Intent(getApplicationContext(),
				HoroscopeInfoActivity.class);
		// Pass variable to detailed view activity using the intent
		if (b.getId() == R.id.next) {
			currentIndex++;
			currentIndex = currentIndex % 5;
			mIntent.putExtra(TabViewActivity.ANIMAL_KEY,
					getString(ids[currentIndex]));
		} else {
			currentIndex += 4;
			currentIndex = currentIndex % 5;
			mIntent.putExtra(TabViewActivity.ANIMAL_KEY,
					getString(ids[currentIndex]));
		}

		// Start the new activity
		startActivity(mIntent);
	}
    
    public void setAnimal(String animal) {
    	
    	ImageView iv = (ImageView)findViewById(R.id.icon);
    	TextView textView1 = (TextView)this.findViewById(R.id.textview1);
    	TextView textView2 = (TextView)this.findViewById(R.id.textview2);
    	if(animal.equalsIgnoreCase(getString(R.string.h_rabbit))) {
    		iv.setImageResource(R.drawable.rabbit);
    		textView1.setText(R.string.h_rabbit);
    		textView2.setText(R.string.rabbit_desc);
    	} else if(animal.equalsIgnoreCase(getString(R.string.h_dragon))) {
    		iv.setImageResource(R.drawable.dragon);
    		textView1.setText(R.string.h_dragon);
    		textView2.setText(R.string.dragon_desc);    		
    	} else if(animal.equalsIgnoreCase(getString(R.string.h_ox))) {
    		iv.setImageResource(R.drawable.ox);
    		textView1.setText(R.string.h_ox);
    		textView2.setText(R.string.ox_desc);    		
    	} else if(animal.equalsIgnoreCase(getString(R.string.h_tiger))) {
    		iv.setImageResource(R.drawable.tiger);
    		textView1.setText(R.string.h_tiger);
    		textView2.setText(R.string.tiger_desc);    		
    	} else if(animal.equalsIgnoreCase(getString(R.string.h_rat))) {
    		iv.setImageResource(R.drawable.rat);
    		textView1.setText(R.string.h_rat);
    		textView2.setText(R.string.rat_desc);     		
    	}
    }
    
    
}