package com.example.horoscope;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter implements ListAdapter {

	private Context mContext;

	private Integer[] thumbsDrawableIds = { R.drawable.horse, R.drawable.tiger,
			R.drawable.rabbit, R.drawable.sheep, R.drawable.snake };

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(thumbsDrawableIds[position]);
		return imageView;
	}

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return thumbsDrawableIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}
}
