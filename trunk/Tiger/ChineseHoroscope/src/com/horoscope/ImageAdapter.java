package com.horoscope;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Gad
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
		
		/*ImageView imageView;
		if (convertView == null) {			
			// if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);
		*/
		/*
		 * setting tags to the icons.
		 * 
		 */
		//create textview with an image above the text
		TextView textView=new TextView(mContext);
		String [] horStrings= mContext.getResources().getStringArray(R.array.horoscope_array);
		//imageView.setTag(horStrings[position%12]);
		textView.setTag(horStrings[position%12]);
		textView.setText(horStrings[position%12]);//%12 because I increased the list size
		Drawable img = mContext.getResources().getDrawable(mThumbIds[position]);
		img.setBounds(0,0,32,46);
		
		//textView.setLayoutParams(new GridView.LayoutParams(90, 90));
		textView.setCompoundDrawablesWithIntrinsicBounds(null,img, null, null);

		return textView;
	}

	// references to our images
	/*
	private Integer[] mThumbIds = { R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar,R.drawable.rat,
			R.drawable.ox, R.drawable.tiger,
			R.drawable.hare, R.drawable.dragon,
			R.drawable.snake, R.drawable.horse,
			R.drawable.sheep, R.drawable.monkey,
			R.drawable.rooster, R.drawable.dog,
			R.drawable.boar};
			*/
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