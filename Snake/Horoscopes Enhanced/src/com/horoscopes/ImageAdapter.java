package com.horoscopes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter implements ListAdapter {

	private Context mContext;

	private Integer[] thumbsDrawableIds = { R.drawable.horse, R.drawable.tiger,
			R.drawable.rabbit, R.drawable.sheep, R.drawable.snake };

	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {

			LayoutInflater li = LayoutInflater.from(mContext);
			v = li.inflate(R.layout.grid_icon, null);
			TextView tv = (TextView) v.findViewById(R.id.icon_text);
			tv.setText((mContext.getResources().getStringArray(
					R.array.horoscope_array)[position]));
			ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
			iv.setImageResource(thumbsDrawableIds[position]);

		} else {
			v = convertView;
		}

		return v;
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
