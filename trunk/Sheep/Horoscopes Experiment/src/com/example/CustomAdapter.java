package com.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context mcontext;
	LayoutInflater lf;
	String[] tdata;

	public CustomAdapter(Context c) {
		mcontext = c;
		lf = LayoutInflater.from(mcontext);
		tdata = c.getResources().getStringArray(R.array.horo_array);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return tdata.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder h;
		if(convertView == null)
		{
			convertView = lf.inflate(R.layout.list_menu, null);
			h = new Holder();
			h.iv = (ImageView) convertView.findViewById(R.id.iconLine);
			h.rb = (RatingBar) convertView.findViewById(R.id.rate);
			h.tv = (TextView) convertView.findViewById(R.id.textLine);
			convertView.setOnClickListener(new OnClickListener() {
		          @Override
		          public void onClick(View v) {
		        	  Intent i = new Intent(mcontext, LinearLayouts.class);

		      		Bundle bundle = new Bundle();
		      		bundle.putInt("position", position);
		      		i.putExtras(bundle);
		      		mcontext.startActivity(i);    
		          }
		        });
			convertView.setTag(h);
		}
		else
		{
			h = (Holder) convertView.getTag();
		}
		
		h.tv.setText(tdata[position]);
		h.iv.setImageResource(mThumbIds[position]);
		return convertView;
	}

	private Integer[] mThumbIds = { R.drawable.horse, R.drawable.sheep,
			R.drawable.snake, R.drawable.rabbit };

}

class Holder {
	TextView tv;
	ImageView iv;
	RatingBar rb;
}
