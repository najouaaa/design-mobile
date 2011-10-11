package com.example;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
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
    	View view;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            LayoutInflater li = LayoutInflater.from(mContext);
            view = li.inflate(R.layout.icon, null);
			TextView tv = (TextView)view.findViewById(R.id.icon_text);
			tv.setText(mThumbText[position]);
			
			tv.setCompoundDrawablesWithIntrinsicBounds(0, mThumbIds[position],0, 0);
        	  } else {
            view = convertView;
        }

        
        
        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.rabbit, R.drawable.horse, R.drawable.sheep, R.drawable.snake
    };
    private String[] mThumbText = {
            "Rabbit", "Horse", "Sheep","Snake"
    };
}