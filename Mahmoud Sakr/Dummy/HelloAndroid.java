package com.example;

import android.app.Activity;
import android.os.Bundle;


public class HelloAndroid extends Activity {
	@override
	protected void onCreate (Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.main);
		
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_horoscope);
		String[] horoscopes = getResources().getStringArray(R.array.horoscopes_array);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, horoscopes);
	}
}