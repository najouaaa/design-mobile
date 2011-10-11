package com.horoscope;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


/**
 * @author Dina
 */
public class HoroscopesList extends Activity {
    /** Called when the activity is first created. */
    private ArrayList <HashMap<String, Object>> horoscopes_hashmap;
    private static final String TITLEKEY = "horoscopetitle";
    private static final String IMGKEY = "icon";
    private static final String RATINGKEY = "ratings";
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView listView = (ListView)findViewById(R.id.list);
        horoscopes_hashmap = new ArrayList<HashMap<String,Object>>();
        final String[] horoscopes = getResources().getStringArray(R.array.horoscope_array);
        
        listView.setOnItemClickListener(new OnItemClickListener() {
			/***
			 * Called when selecting a horoscope from the list
			 * goes to the detailed view
			 * 
			 * @param parent
			 * @param view
			 * @param position: position of horoscope in the list
			 * @param id: horoscope id in the list
			 */
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(getBaseContext(), HoroscopeDetails.class);
				i.putExtra("pos", position);
				i.putExtra("title", horoscopes[position]);
				startActivity(i);
			}
		});
  
        hashmapElement("Rat",R.drawable.rat_zodiac, 2);
        hashmapElement("Ox",R.drawable.ox_zodiac, 5);
        hashmapElement("Tiger",R.drawable.tiger_zodiac, 3);
        hashmapElement("Rabit",R.drawable.rabbit_zodiac, 8);
        hashmapElement("Dragon",R.drawable.dragon_zodiac, 1);
        hashmapElement("Snake",R.drawable.snake_zodiac, 2);
        hashmapElement("Horse",R.drawable.horse_zodiac, 4);
        hashmapElement("Sheep",R.drawable.sheep_zodiac, 7);
        hashmapElement("Monkey",R.drawable.monkey_zodiac, 3);
        hashmapElement("Rooster",R.drawable.rooster_zodiac, 2);
        hashmapElement("Dog",R.drawable.dog_zodiac, 9);
        hashmapElement("Pig",R.drawable.pig_zodiac, 10);
       
        listView.setAdapter(new myListAdapter(horoscopes_hashmap,this));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
    
    /***
     * 
     * @author Dina
     *
     */
    private class myListAdapter extends BaseAdapter{
        private ArrayList<HashMap<String, Object>> Horoscopes;
        private LayoutInflater mInflater;
        public myListAdapter(ArrayList<HashMap<String, Object>> horoscopes, Context context){
            Horoscopes = horoscopes;
            mInflater = LayoutInflater.from(context);
        }
        
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return Horoscopes.size();
        }
 
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return Horoscopes.get(position);
        }
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }
        
        /***
         * @param position
         * @param convertView
         * @param parent
         * 
         * customized view with text, image & rating
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
             if (convertView == null) {
                 convertView = mInflater.inflate(R.layout.listbox, null);
                 // Creates a ViewHolder and store references to the two children views
                 // we want to bind data to.
                 holder = new ViewHolder();
                 holder.v = (TextView) convertView.findViewById(R.id.title);
                 holder.icon = (ImageView) convertView.findViewById(R.id.img);
                 holder.rating = (RatingBar)convertView.findViewById(R.id.star);
                 convertView.setTag(holder);
             }else {
                 // Get the ViewHolder back to get fast access to the TextView
                 // and the ImageView.
                 holder = (ViewHolder) convertView.getTag();
             }
                // Bind the data with the holder.
                holder.v.setText((String) Horoscopes.get(position).get(TITLEKEY));
                holder.icon.setImageResource((Integer)Horoscopes.get(position).get(IMGKEY));
                holder.rating.setRating((Integer)Horoscopes.get(position).get(RATINGKEY));
                return convertView;
        }
        /***
         * 
         * @author Dina
         *
         */
        class ViewHolder {
            TextView v;
            ImageView icon;
            RatingBar rating;
        }
         
    }
 
    /***
     * 
     * @param title
     * @param img
     * @param rate
     * 
     * insert zodiacs in the horoscopes hashmap
     */
     public void hashmapElement(String title, int img, int rate)
     {
    	 HashMap<String, Object> hm;
    	 hm = new HashMap<String, Object>();
         hm.put(TITLEKEY, title);
         hm.put(IMGKEY, img);
         hm.put(RATINGKEY,rate);
         horoscopes_hashmap.add(hm);
     }

}
