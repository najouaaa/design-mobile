package com.horoscope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * @author kamasheto
 */
public class HoroscopeSearch extends Activity {
	/**
	 * Shortlink for the horoscopes array (extracted from strings.xml)
	 */
	String[] horoscopes;

	/**
	 * 
	 */
	// AutoCompleteTextView textView;

	Spinner spinner;

	boolean activateListener = false;

	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.search);
		horoscopes = getResources().getStringArray(R.array.horoscope_array);

		Spinner spinner = (Spinner) findViewById(R.id.spinner_horoscope);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.horoscope_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
		activateListener = true;
	}

	/**
	 * Shortcut: Shows modal box with the desired message.
	 * 
	 * @param text
	 *            message to show
	 */
	public void showMessage(String text) {
		Toast.makeText(HoroscopeSearch.this, text, Toast.LENGTH_SHORT).show();
	}

	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			if (!activateListener) {
				return;
			}
			//
			int position = 0;
			/*
			 * Are we searching for an empty box?
			 */
			// if (textView.getText() == null) {
			// showMessage("Please enter a search query.");
			// return;
			// }

			/*
			 * Does this term exist in anything? For now we're searching case
			 * insensitive, but do we want that?
			 */
			// String query = textView.getText().toString();
			String query = parent.getItemAtPosition(pos).toString();

			/*
			 * 
			 */
			if (query.length() == 0) {
				showMessage("Please enter a search query.");
				return;
			}
			//
			boolean found = false;
			for (String horoscope : horoscopes) {
				if (horoscope.toLowerCase().contains(query.toLowerCase())) {
					found = true;
					query = horoscope;
					break;
				}
				position++;
			}
			//
			if (!found) {
				showMessage("No matches found.");
				return;
			}

			Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
			i.putExtra("pos", position);
			i.putExtra("title", query);
			startActivity(i);
			// Toast.makeText(parent.getContext(), "The planet is " +
			// parent.getItemAtPosition(pos).toString(),
			// Toast.LENGTH_LONG).show();
		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
		}
	}
}
