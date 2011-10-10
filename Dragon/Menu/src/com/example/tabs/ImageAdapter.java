package com.example.tabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{
	   private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return mThumbIds.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	       
	        View row;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	        	 ImageView imageView = new ImageView(mContext);
	            LayoutInflater inflater = (LayoutInflater)
	            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            row=inflater.inflate(R.layout.single_grid_item, parent, false);
	            TextView label=(TextView)row.findViewById(R.id.image_name);
	            label.setText(mTexts[position]);
	            imageView=(ImageView)row.findViewById(R.id.album_image);
	            imageView.setImageResource(mThumbIds[position]);
	        } else {
	            row = (View) convertView;
	        }

	       
	        return row;
	    }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.dragon, R.drawable.horse,
	            R.drawable.rabbit, R.drawable.snake,R.drawable.sheep,
	    };
	    private String[] mTexts = {
	            "dragon", "horse",
	            "rabbit", "snake","sheep",
	    };
	}
