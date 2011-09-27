package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Hello_AndroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     	super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Hello Dina, \nyour Chinese name is Han Tu nu \nand your Chinese horoscope is the Horse");
        setContentView(tv);
    }
}