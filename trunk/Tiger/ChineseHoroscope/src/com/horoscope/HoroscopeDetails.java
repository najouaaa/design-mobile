/**
 * 
Author: Dalia El Badawi
Created: 24/09/2011
 *
**/

package com.horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HoroscopeDetails extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int x = R.drawable.icon; 
        int y = getIntent().getIntExtra("text1", 0);
        int z = getIntent().getIntExtra("text2", 0);
        
        
        setContentView(R.layout.linear);
        setImageAndText(x,y,z);
    }
    
    public void setImageAndText(int x,int y,int z){
    	ImageView horoscope = (ImageView) findViewById(R.id.horoscope_image);
        horoscope.setImageDrawable(getResources().getDrawable(x));
        
        TextView text1 = (TextView) findViewById(R.id.text1);
        text1.setText(getResources().getString(y));
        
        TextView text2 = (TextView) findViewById(R.id.text2);
        text2.setText(getResources().getString(z));
    	
    }
}