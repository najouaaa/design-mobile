package com.example.helloViews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

	/** instance parameter representing the context where the image adapter is running*/
	private Context context;
	
	/** list of IDs of images included  in view from resources*/
	private Integer[] thumbnails= {R.drawable.ox, R.drawable.dragon, R.drawable.rabbit, R.drawable.rat, R.drawable.tiger };
	
	/**Constructor for generating image adapter*/
	public ImageAdapter(Context c){
		this.context = c;
	}// end constructor
	
	public int getCount() {
		return thumbnails.length;
	}// end getCount
	
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}// end getItem

	public long getItemId(int position) {
		return thumbnails[position];
	}// end getItemId
	
	
	
	public View getView(int position, View convertView, ViewGroup parent) {
		 ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(context);
	            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);
	            imageView.setTag(getAnimalIdBy(position));
	            	           
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(thumbnails[position]);
	        return imageView;
	}// end getView
	
	private int getAnimalIdBy(int position){
		
		int imageId = thumbnails[position];
		/**/
			switch(imageId){
			case R.drawable.dragon: return R.string.h_dragon;
			case R.drawable.rat: return R.string.h_rat;
			case R.drawable.ox: return R.string.h_ox;
			case R.drawable.rabbit: return R.string.h_rabbit;
			case R.drawable.tiger: return R.string.h_tiger;
			default: return -1;
			}// end switch: return name of animal according to image
		}

	

}
