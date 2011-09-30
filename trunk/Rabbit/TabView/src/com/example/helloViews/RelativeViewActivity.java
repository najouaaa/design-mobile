package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeViewActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.relative_view);
	}


	/** Method called when buttons are clicked */
	public void onClickButton(View v) {
		// Get the button that generated the click event 
		Button b = (Button) v;
	

		// Generate intent to move between activities
		Intent mIntent = new Intent(getApplicationContext(),
				HoroscopeInfoActivity.class);
		// Pass variable to detailed view activity using the intent
		mIntent.putExtra(TabViewActivity.ANIMAL_KEY, b.getText());
		// Start the new activity
		startActivity(mIntent);

	}// end onClickButton
}