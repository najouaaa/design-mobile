package com.horoscopes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LinearLayoutActivity extends Activity {
	/** Called when the activity is first created. */

	int position;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);

		ImageView imageView = (ImageView) findViewById(R.id.horoscope_image);
		TextView titleTextView = (TextView) findViewById(R.id.horoscope_title_textview);
		TextView descriptionTextView = (TextView) findViewById(R.id.horoscope_desc_textview);

		Bundle b = getIntent().getExtras();

		int nameId = b.getInt("name_id");
		titleTextView.setText(nameId);

		int descriptionId = b.getInt("desc_id");
		descriptionTextView.setText(descriptionId);

		int imageId = b.getInt("image_id");
		imageView.setImageResource(imageId);
		
		int arrayId = b.getInt("array_id");
	//	String[] files = getResources().getStringArray(arrayId) ;
		String[] files = getResources().getStringArray(R.array.horse_friend) ;
		ViewStub stub = (ViewStub) findViewById(R.id.stub1);
		ArrayAdapter<String> content=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,files);
		
		LayoutInflater factory = LayoutInflater.from(this);
		final View textEntryView = (View)factory.inflate(R.layout.layout1,null);
		
		//TextView people = (TextView)textEntryView.findViewById(R.id.friends);
	//	people.setText(files[0]);
	//	Log.e("adapter", ""+content.getCount()+" "+people.getText());
		
		View inflated=stub.inflate();
	  ListView people=(ListView)textEntryView.findViewById(R.id.friends);
	//	ListView people=(ListView)inflated.findViewById(R.id.friends);
		people.setAdapter(content);

		position = b.getInt("position");
		if (position == 0) {
			ImageButton back = (ImageButton) findViewById(R.id.backButton);
			back.setEnabled(false);
		} else {
			if (position == 4) {
				ImageButton next = (ImageButton) findViewById(R.id.nextButton);
				next.setEnabled(false);
			}
		}
	}

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

	public void goHome(View v) {
		Intent tabIntent = new Intent(getBaseContext(), TabViewActivity.class);
		startActivity(tabIntent);
	}
}