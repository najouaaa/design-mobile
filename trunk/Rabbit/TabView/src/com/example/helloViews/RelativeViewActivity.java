package com.example.helloViews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeViewActivity extends Activity {
	int Pos;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.relative_view);

	    Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.horoscopes_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    
	    spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());		
		
	}
	
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener {
		
	    public void onItemSelected(AdapterView<?> parent,
	        View view, int pos, long id) {
	    	
	    	 if(RelativeViewActivity.this.Pos != pos){
	   	           
	    	
	    		 ViewStub stub1 = (ViewStub) findViewById(R.id.stub);
	    		 String animalName = parent.getItemAtPosition(pos).toString();
	   
	    		 if(stub1 != null)  {
	    			 View inflated = stub1.inflate();
	    		 }
	    	
	    		 setAnimal(animalName);
	    		 RelativeViewActivity.this.Pos = pos;
	    	 	}// end if
	   	    }// end onItemSelected

	    
	    public void setAnimal(String animal) {
	    	
	    	ImageView iv = (ImageView)findViewById(R.id.icon);
	    	TextView textView1 = (TextView)findViewById(R.id.textview1);
	    	TextView textView2 = (TextView)findViewById(R.id.textview2);
	    	
	    	if(animal.equalsIgnoreCase(getString(R.string.h_rabbit))) {
	    		iv.setImageResource(R.drawable.rabbit);
	    		textView1.setText(R.string.h_rabbit);
	    		textView2.setText(R.string.rabbit_desc);
	    	} else if(animal.equalsIgnoreCase(getString(R.string.h_dragon))) {
	    		iv.setImageResource(R.drawable.dragon);
	    		textView1.setText(R.string.h_dragon);
	    		textView2.setText(R.string.dragon_desc);    		
	    	} else if(animal.equalsIgnoreCase(getString(R.string.h_ox))) {
	    		iv.setImageResource(R.drawable.ox);
	    		textView1.setText(R.string.h_ox);
	    		textView2.setText(R.string.ox_desc);    		
	    	} else if(animal.equalsIgnoreCase(getString(R.string.h_tiger))) {
	    		iv.setImageResource(R.drawable.tiger);
	    		textView1.setText(R.string.h_tiger);
	    		textView2.setText(R.string.tiger_desc);    		
	    	} else if(animal.equalsIgnoreCase(getString(R.string.h_rat))) {
	    		iv.setImageResource(R.drawable.rat);
	    		textView1.setText(R.string.h_rat);
	    		textView2.setText(R.string.rat_desc);     		
	    	}
	    	
	    }// end setAnimal
	    
	    public void onNothingSelected(AdapterView parent) {
	      // Do nothing.
	    }// end onNothingSelected
	}// end MyOnItemSelectedListener

}// end RelativeViewActivity