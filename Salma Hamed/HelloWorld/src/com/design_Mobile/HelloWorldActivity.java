package com.design_Mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
   //     Object o = null;
   //     o.toString();
        
        setContentView(R.layout.main);
//        TextView h=new TextView(this);
//        String text="Hello \'Salma Hamed\', your Chinese name is \'Huang Sha long\' and your Chinese horoscope is Horse";
//        h.setText(text);
//        setContentView(h);
    }
}