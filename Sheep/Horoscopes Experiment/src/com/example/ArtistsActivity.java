package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class ArtistsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	Intent i = new Intent(ArtistsActivity.this, Lab1Activity.class);
	    		Bundle bundle = new Bundle();
            	if(position==0)
            		bundle.putString("param1", "Rabbit");
            	if(position==1)
            		bundle.putString("param1", "Horse");
            	if(position==2)
            		bundle.putString("param1", "Sheep");
            	if(position==3)
            		bundle.putString("param1", "Snake");
            	i.putExtras(bundle);
	    		startActivity(i);
            }
        });
    }
}