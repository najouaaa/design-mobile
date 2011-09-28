package com.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/**
 * @author kamasheto
 */
public class HoroscopeSearch extends Activity {
	String[] horoscopes;

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.search);
		horoscopes = getResources().getStringArray(R.array.horoscope_array);
		
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_horoscope);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view, horoscopes);
		textView.setAdapter(adapter);
	}

	public void onOkClick(View view) {
		int position = 0;
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_horoscope);
		String query = textView.getText().toString();
		//
		for (String horoscope : horoscopes) {
			if (horoscope.contains(query)) {
				break;
			}
			position++;
		}
		if (position == horoscopes.length)
			return;
		
		Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
		i.putExtra("pos", position);
		i.putExtra("title", ((TextView) view).getText());
		startActivity(i);
	}

	public void onCancelClick(View view) {

	}
}
