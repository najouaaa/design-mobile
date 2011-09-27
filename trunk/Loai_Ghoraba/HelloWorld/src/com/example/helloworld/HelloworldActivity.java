package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;

public class HelloworldActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Object o = null;
		o.toString();
		setContentView(R.layout.main);
	}
}