package com.horoscope;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Gad
 * @author Dalia
 */

public class ImageAdapter extends BaseAdapter {
	/*
	 * This adapter creates the item of the Grid view.
	 */
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		//create textview with an image above the text
		TextView textView=new TextView(mContext);
		String [] horStrings= mContext.getResources().getStringArray(R.array.horoscope_array);
		//set tag to view, to call with
		textView.setTag(horStrings[position%12]);
		//the text
		textView.setText(horStrings[position%12]);//%12 because I increased the list size
		//the icon
		Drawable img = mContext.getResources().getDrawable(mThumbIds[position]);
		img.setBounds(0,0,32,46);
		
		//textView.setLayoutParams(new GridView.LayoutParams(90, 90));
		textView.setCompoundDrawablesWithIntrinsicBounds(null,img, null, null);

		return textView;
	}

	// references to our images
	
	private Integer[] mThumbIds = { R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac,R.drawable.rat_zodiac,
			R.drawable.ox_zodiac, R.drawable.tiger_zodiac,
			R.drawable.rabbit_zodiac, R.drawable.dragon_zodiac,
			R.drawable.snake_zodiac, R.drawable.horse_zodiac,
			R.drawable.sheep_zodiac, R.drawable.monkey_zodiac,
			R.drawable.rooster_zodiac, R.drawable.dog_zodiac,
			R.drawable.pig_zodiac

	};

}