package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class CustomListView extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.custom_view); 
        
        setRatingBars();
    }
   
   public void setRatingBars(){
	   
	   final RatingBar ratingbar1 = (RatingBar) findViewById(R.id.ratingbar1);
       ratingbar1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {}
       });
       
       final RatingBar ratingbar2 = (RatingBar) findViewById(R.id.ratingbar2);
       ratingbar2.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {}
       });
       
       final RatingBar ratingbar3 = (RatingBar) findViewById(R.id.ratingbar3);
       ratingbar3.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {}
       });
       
       final RatingBar ratingbar4 = (RatingBar) findViewById(R.id.ratingbar4);
       ratingbar4.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {}
       });
       
       final RatingBar ratingbar5 = (RatingBar) findViewById(R.id.ratingbar5);
       ratingbar5.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {}
       });
   }
   
   public void onClickRow(View v) {
	  	
		TableRow tr = (TableRow) v;
	
		String animalName = (String) tr.getTag();
		
		Intent mIntent = new Intent(getApplicationContext(),
				HoroscopeInfoActivity.class);
		
		mIntent.putExtra(TabViewActivity.ANIMAL_KEY, animalName);
	
		startActivity(mIntent);
	}
}