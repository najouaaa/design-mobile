package com.example.helloViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/** This class is used as an adapter that generates an image with an underlying caption component*/
public class ImageWithCaptionAdapter extends BaseAdapter {

	/** instance parameter representing the context where the image adapter is running*/
	private Context context;
	
	/** list of IDs of images included  in view from resources*/
	private Integer[] thumbnails= {R.drawable.ox, R.drawable.dragon, R.drawable.rabbit, R.drawable.rat, R.drawable.tiger };
	
	/**Constructor for generating image adapter*/
	public ImageWithCaptionAdapter(Context c){
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

		View gridItem;

		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			// Get the needed inflater to read the XML layout file
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// Read the Layout description from the XML file and load it to the
			// view
			gridItem = inflater.inflate(R.layout.grid_item, null);

			// Get the animal ID from the R file to get the equivalent text and
			// set the tags
			int animalId = getAnimalIdBy(position);

			// Get the image component in the grid item custom component
			ImageView imageView = (ImageView) gridItem
					.findViewById(R.id.gridImageView);
			// Set the display image and the tag property to transmit the animal
			// ID between classes
			imageView.setTag(animalId);
			imageView.setImageResource(thumbnails[position]);

			// Get the text component in the grid item custom component
			TextView tv = (TextView) gridItem.findViewById(R.id.gridTextView);
			// Set the animal name to be displayed
			tv.setText(context.getString(animalId));

		} else {
			gridItem = convertView;
		}

		return gridItem;

	}// end getView

	/** This method is used to map the image to its equivalent animal ID from the R file
	 *  using its position in the bound array*/
	private int getAnimalIdBy(int position) {

		int imageId = thumbnails[position];
		/* Get the animal ID according to the image ID*/
		switch (imageId) {
		case R.drawable.dragon:
			return R.string.h_dragon;
		case R.drawable.rat:
			return R.string.h_rat;
		case R.drawable.ox:
			return R.string.h_ox;
		case R.drawable.rabbit:
			return R.string.h_rabbit;
		case R.drawable.tiger:
			return R.string.h_tiger;
		default:
			return -1;
		}// end switch: return name of animal according to image
	}// end getAnimalIdBy
	
}// end class
