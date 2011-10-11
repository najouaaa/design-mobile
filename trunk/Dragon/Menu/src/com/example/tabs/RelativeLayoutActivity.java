package com.example.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class RelativeLayoutActivity extends Activity{
	
	boolean inflated = false;
	ViewStub stub;
    View inflatedView;
    TextView text;
    ImageView image;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.relative);

	    Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.horoscopes, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	}
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener {

	    public void onItemSelected(AdapterView<?> parent,
	        View view, int pos, long id) {
	        
	    	if(!inflated)
	    	{
	    		stub = (ViewStub) findViewById(R.id.stub) ;
    			inflatedView = stub.inflate();
    			text = (TextView) inflatedView.findViewById(R.id.description);
    			image = (ImageView) inflatedView.findViewById(R.id.img);
    			inflated = true;
	    	}
	    	
	    	switch(pos){
	    		
	    		case 0:
	    			text.setText(" ");
	    			image.setVisibility(ImageView.INVISIBLE);
	    		break;
	    		
	    		case 1:
	    			image.setVisibility(ImageView.VISIBLE);
	    	        text.setText(R.string.HorseDescription);
	    	        image.setImageResource(R.drawable.horse);
	    		break;
	    		
	    		case 2:
	    	        text.setText(R.string.DragonDescription);
	    	        image.setVisibility(ImageView.VISIBLE);
	    	        image.setImageResource(R.drawable.dragon);
	    		break;
	    		
	    		case 3:
	    	        text.setText(R.string.SnakeDescription);
	    	        image.setVisibility(ImageView.VISIBLE);
	    	        image.setImageResource(R.drawable.snake);
		    	break;
		    		
	    		case 4:
	    	        text.setText(R.string.SheepDescription);
	    	        image.setVisibility(ImageView.VISIBLE);
	    	        image.setImageResource(R.drawable.sheep);
		    	break;
		    		
	    		case 5:
	    	        text.setText(R.string.RabbitDescription);
	    	        image.setVisibility(ImageView.VISIBLE);
	    	        image.setImageResource(R.drawable.rabbit);
		    	break;
	    	}
	      
	    }

	    public void onNothingSelected(AdapterView parent) {
	      // Do nothing.
	    }
	}

}