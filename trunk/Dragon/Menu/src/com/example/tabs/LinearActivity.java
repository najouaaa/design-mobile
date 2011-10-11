package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class LinearActivity extends Activity implements View.OnClickListener,
		RatingBar.OnRatingBarChangeListener {
	// defining handler classes as a private inner class

	public static int the_id = 0;
	TextView content1;
	TextView content2;
	ImageView myImg;
	Button button1;
	Button button2;
	RatingBar bar;
	String stub_text_;
	boolean inflatable;
	ViewStub mystub;
	TextView stub_text;
	View inflated;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);
		content1 = (TextView) findViewById(R.id.txt1);
		content2 = (TextView) findViewById(R.id.txt2);
		myImg = (ImageView) findViewById(R.id.img);
		button1 = (Button) findViewById(R.id.first_button);
		button2 = (Button) findViewById(R.id.second_button);
		button1.setClickable(true);
		button2.setClickable(true);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);

		mystub = (ViewStub) findViewById(R.id.stub);
		
		switch (the_id) {
		case 1:
			content1.setText(R.string.HorseName);
			content2.setText(R.string.HorseDescription);
			myImg.setImageResource(R.drawable.horse);
			stub_text_ = getString(R.string.HorseFriends);
			break;
		case 0:
			content1.setText(R.string.DragonName);
			content2.setText(R.string.DragonDescription);
			myImg.setImageResource(R.drawable.dragon);
			stub_text_ = getString(R.string.DragonFriends);
			break;
		case 3:
			content1.setText(R.string.SnakeName);
			content2.setText(R.string.SnakeDescription);
			myImg.setImageResource(R.drawable.snake);
			stub_text_ = getString(R.string.SnakeFriends);
			int i = 1;
			break;
		case 4:
			content1.setText(R.string.SheepName);
			content2.setText(R.string.SheepDescription);
			myImg.setImageResource(R.drawable.sheep);
			stub_text_ = getString(R.string.SheepFriends);
			break;
		case 5:
			content1.setText(R.string.RabbitName);
			content2.setText(R.string.RabbitDescription);
			myImg.setImageResource(R.drawable.rabbit);
			stub_text_ = getString(R.string.RabbitFriends);
			break;
		}
		
		if(!stub_text_.equals(""))
		{
			inflated = mystub.inflate();
			int  id  =  inflated.getId();
			stub_text = (TextView) inflated.findViewById(id);
			stub_text.setText(stub_text_);
		}		

		bar = (RatingBar) findViewById(R.id.bar);
		bar.setOnRatingBarChangeListener(this);
	}

	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromTouch) {
		bar.setRating(rating);
		Toast.makeText(LinearActivity.this, "New Rating: " + rating,
				Toast.LENGTH_SHORT).show();
	}

	public void onClick(View v) {
		if (button1.isPressed()) {
			the_id--;
			if (the_id < 0)
				the_id = 4;
		} else if (button2.isPressed()) {
			the_id++;
			if (the_id > 4)
				the_id = 0;
		}
		switch (the_id) {
		case 1:
			content1.setText(R.string.HorseName);
			content2.setText(R.string.HorseDescription);
			myImg.setImageResource(R.drawable.horse);
			break;
		case 0:
			content1.setText(R.string.DragonName);
			content2.setText(R.string.DragonDescription);
			myImg.setImageResource(R.drawable.dragon);
			break;
		case 3:
			content1.setText(R.string.SnakeName);
			content2.setText(R.string.SnakeDescription);
			myImg.setImageResource(R.drawable.snake);
			int i = 0;
			break;
		case 4:
			content1.setText(R.string.SheepName);
			content2.setText(R.string.SheepDescription);
			myImg.setImageResource(R.drawable.sheep);
			break;
		case 2:
			content1.setText(R.string.RabbitName);
			content2.setText(R.string.RabbitDescription);
			myImg.setImageResource(R.drawable.rabbit);
			break;
		}

	}

}
