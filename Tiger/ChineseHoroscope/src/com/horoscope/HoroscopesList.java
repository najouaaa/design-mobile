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
    // I use HashMap arraList which takes objects
    private ArrayList <HashMap<String, Object>> horoscopes_hashmap;
    private static final String TITLEKEY = "bookname";
    private static final String IMGKEY = "iconfromraw";
    private static final String RATINGKEY = "ratings";
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView listView = (ListView)findViewById(R.id.list);
        horoscopes_hashmap = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> hm;
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
	
        
        //With the help of HashMap add Key, Values of Book, like name,price and icon path
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Rat");
        hm.put(IMGKEY, R.drawable.rat_zodiac); //i have images in res/raw folder
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Ox");
        hm.put(IMGKEY, R.drawable.ox_zodiac);
        hm.put(RATINGKEY, 1);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Tiger");
        hm.put(IMGKEY, R.drawable.tiger_zodiac);
        hm.put(RATINGKEY,3);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Rabit");
        hm.put(IMGKEY, R.drawable.rabbit_zodiac);
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Dragon");
        hm.put(IMGKEY, R.drawable.dragon_zodiac); //i have images in res/raw folder
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Snake");
        hm.put(IMGKEY, R.drawable.snake_zodiac);
        hm.put(RATINGKEY, 1);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Horse");
        hm.put(IMGKEY, R.drawable.horse_zodiac);
        hm.put(RATINGKEY,3);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Sheep");
        hm.put(IMGKEY, R.drawable.sheep_zodiac);
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
        
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Monkey");
        hm.put(IMGKEY, R.drawable.monkey_zodiac); //i have images in res/raw folder
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Rooster");
        hm.put(IMGKEY, R.drawable.rooster_zodiac);
        hm.put(RATINGKEY, 1);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Dog");
        hm.put(IMGKEY, R.drawable.dog_zodiac);
        hm.put(RATINGKEY,3);
        horoscopes_hashmap.add(hm);
         
        hm = new HashMap<String, Object>();
        hm.put(TITLEKEY, "Pig");
        hm.put(IMGKEY, R.drawable.pig_zodiac);
        hm.put(RATINGKEY, 2);
        horoscopes_hashmap.add(hm);
    
        listView.setAdapter(new myListAdapter(horoscopes_hashmap,this));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
     
    private class myListAdapter extends BaseAdapter{
        private ArrayList<HashMap<String, Object>> Horoscopes;
        private LayoutInflater mInflater;
        public myListAdapter(ArrayList<HashMap<String, Object>> books, Context context){
            Horoscopes = books;
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
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            // A ViewHolder keeps references to children views to avoid unneccessary calls
            // to findViewById() on each row.
            ViewHolder holder;
            // When convertView is not null, we can reuse it directly, there is no need
            // to reinflate it. We only inflate a new View when the convertView supplied
            // by ListView is null
             if (convertView == null) {
                 convertView = mInflater.inflate(R.layout.listbox, null);
                 // Creates a ViewHolder and store references to the two children views
                 // we want to bind data to.
                 holder = new ViewHolder();
                 holder.v = (TextView) convertView.findViewById(R.id.title);
            //     holder.v1 = (TextView) convertView.findViewById(R.id.text2);
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
        class ViewHolder {
            TextView v;
            TextView v1;
            ImageView icon;
            RatingBar rating;
        }
         
    }
 
     

}
