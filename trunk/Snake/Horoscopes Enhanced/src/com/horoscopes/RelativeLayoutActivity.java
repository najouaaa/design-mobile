package com.horoscopes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class RelativeLayoutActivity extends Activity {

	boolean Flag;
	int position;

	/** Called when the activity is first created. */
	@Override
	/**
	 * @author Mariam
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinner_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

	}

	/**
	 * 
	 * @author Mariam
	 * 
	 */

	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			if (Flag) {
				View importPanel = ((ViewStub) findViewById(R.id.stub))
						.inflate();
				int nameId = 0;
				int descriptionId = 0;
				int imageId = 0;
				position = pos - 1;

				switch (pos) {

				case 1:
					nameId = R.string.horse;
					descriptionId = R.string.horse_desc;
					imageId = R.drawable.horse;
					break;
				case 2:
					nameId = R.string.tiger;
					descriptionId = R.string.tiger_desc;
					imageId = R.drawable.tiger;
					break;
				case 3:
					nameId = R.string.rabbit;
					descriptionId = R.string.rabbit_desc;
					imageId = R.drawable.rabbit;
					break;
				case 4:
					nameId = R.string.sheep;
					descriptionId = R.string.sheep_desc;
					imageId = R.drawable.sheep;
					break;
				case 5:
					nameId = R.string.snake;
					descriptionId = R.string.snake_desc;
					imageId = R.drawable.snake;
					break;
				}

				ImageView imageView = (ImageView) findViewById(R.id.horoscope_image);
				TextView titleTextView = (TextView) findViewById(R.id.horoscope_title_textview);
				TextView descriptionTextView = (TextView) findViewById(R.id.horoscope_desc_textview);

				titleTextView.setText(nameId);
				descriptionTextView.setText(descriptionId);
				imageView.setImageResource(imageId);
				parent.setEnabled(false);

				/**
				 * @author Rawan's next/back button
				 */

				if (pos == 1) {
					ImageButton back = (ImageButton) findViewById(R.id.backButton);
					back.setEnabled(false);
				} else {
					if (pos == 5) {
						ImageButton next = (ImageButton) findViewById(R.id.nextButton);
						next.setEnabled(false);
					}
				}

			}

			Flag = true;
		}

		public void onNothingSelected(AdapterView<?> parent) {
			// Do nothing.
		}
	}

	/**
	 * 
	 * @author Rawan
	 */
	public void goNext(View v) {
		int nameId = 0;
		int descriptionId = 0;
		int imageId = 0;
		switch (position) {
		case 0:
			nameId = R.string.tiger;
			descriptionId = R.string.tiger_desc;
			imageId = R.drawable.tiger;
			break;
		case 1:
			nameId = R.string.rabbit;
			descriptionId = R.string.rabbit_desc;
			imageId = R.drawable.rabbit;
			break;
		case 2:
			nameId = R.string.sheep;
			descriptionId = R.string.sheep_desc;
			imageId = R.drawable.sheep;
			break;
		case 3:
			nameId = R.string.snake;
			descriptionId = R.string.snake_desc;
			imageId = R.drawable.snake;
		}
		position++;
		Bundle b = new Bundle();
		b.putInt("name_id", nameId);
		b.putInt("desc_id", descriptionId);
		b.putInt("image_id", imageId);
		b.putInt("position", position);
		Intent detailsIntent = new Intent(getBaseContext(),
				LinearLayoutActivity.class);
		detailsIntent.putExtras(b);
		startActivity(detailsIntent);
	}

	/**
	 * 
	 * @author Rawan
	 */

	public void goBack(View v) {
		int nameId = 0;
		int descriptionId = 0;
		int imageId = 0;
		switch (position) {
		case 1:
			nameId = R.string.horse;
			descriptionId = R.string.horse_desc;
			imageId = R.drawable.horse;
			break;
		case 2:
			nameId = R.string.tiger;
			descriptionId = R.string.tiger_desc;
			imageId = R.drawable.tiger;
			break;
		case 3:
			nameId = R.string.rabbit;
			descriptionId = R.string.rabbit_desc;
			imageId = R.drawable.rabbit;
			break;
		case 4:
			nameId = R.string.sheep;
			descriptionId = R.string.sheep_desc;
			imageId = R.drawable.sheep;
		}
		position--;
		Bundle b = new Bundle();
		b.putInt("name_id", nameId);
		b.putInt("desc_id", descriptionId);
		b.putInt("image_id", imageId);
		b.putInt("position", position);
		Intent detailsIntent = new Intent(getBaseContext(),
				LinearLayoutActivity.class);
		detailsIntent.putExtras(b);
		startActivity(detailsIntent);
	}

	/**
	 * 
	 * @author Rawan
	 */
	public void goHome(View v) {
		Intent tabIntent = new Intent(getBaseContext(), TabViewActivity.class);
		startActivity(tabIntent);
	}

}
