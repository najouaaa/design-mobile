package com.example.hellol10n;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloL10NActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// assign flag.png to the button, loading correct flag image for current
		// locale
		Button b;
		(b = (Button) findViewById(R.id.flag_button))
				.setBackgroundDrawable(this.getResources().getDrawable(
						R.drawable.flag));

		// build dialog box to display when user clicks the flag
		

		// set click listener on the flag to show the dialog box
	}
}