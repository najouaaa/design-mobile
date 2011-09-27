package com.example.helloworld2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorld2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv = new TextView(this);
        tv.setText("Hello, Android...My Chinese name is  An Minghuan....My Chinese horoscope is the Rabbit !!!");
        setContentView(tv);
    }
}