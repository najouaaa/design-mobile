package com.horoscopes;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity extends ListActivity {

	
	static String[] horoscopes;
	static private Integer[] thumbsDrawableIds = { R.drawable.horse, R.drawable.tiger,
			R.drawable.rabbit, R.drawable.sheep, R.drawable.snake };
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		horoscopes  = getResources().getStringArray(
    			R.array.horoscope_array);
		
		 setContentView(R.layout.custom_list_view);
		  SimpleAdapter adapter = new SimpleAdapter(
	        		this,
	        		list,
	        		R.layout.custom_row_view,
	        		new String[] {"text","image"},
	        		new int[] {R.id.text1,R.id.imageEins}
	        		);
		    populateList();
	        setListAdapter(adapter); 
 
		ListView listView = getListView();

		listView.setTextFilterEnabled(true);
				listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				int nameId = 0;
				int descriptionId = 0;
				int imageId = 0;
				switch (position) {
				case 0:
					nameId = R.string.horse;
					descriptionId = R.string.horse_desc;
					imageId = R.drawable.horse;
					break;
				case 1:
					nameId = R.string.tiger;
					descriptionId = R.string.tiger_desc;
					imageId = R.drawable.tiger;
					break;
				case 2:
					nameId = R.string.rabbit;
					descriptionId = R.string.rabbit_desc;
					imageId = R.drawable.rabbit;
					break;
				case 3:
					nameId = R.string.sheep;
					descriptionId = R.string.sheep_desc;
					imageId = R.drawable.sheep;
					break;
				case 4:
					nameId = R.string.snake;
					descriptionId = R.string.snake_desc;
					imageId = R.drawable.snake;
					break;
				}
				Bundle b = new Bundle();
				b.putInt("name_id", nameId);
				b.putInt("desc_id", descriptionId);
				b.putInt("image_id", imageId);
				b.putInt("position", position);
				Intent detailsIntent = new Intent(getBaseContext(),
						LinearLayoutActivity.class);
				detailsIntent.putExtras(b);
				startActivity(detailsIntent);
			}
		});
	}
	
  
	
    static final ArrayList<HashMap<String,Object>> list = 
    	new ArrayList<HashMap<String,Object>>(); 
    private static boolean ht8 = false;
    
    private void populateList() {
    	if(ht8) return;
    	
    	for(int i = 0; i < 5 ; i++)
    	{
    	HashMap<String,Object> temp = new HashMap<String,Object>();
    	temp.put("text", horoscopes[i]); 
        temp.put("image", thumbsDrawableIds[i]);
    	list.add(temp);
    	}
        ht8 = true;
    }
	
}
