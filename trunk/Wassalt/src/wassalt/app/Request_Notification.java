package wassalt.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Request_Notification extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.request_main);
      
      Spinner spinner = (Spinner) findViewById(R.id.spinner);
	  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
	  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  spinner.setAdapter(adapter);
	  spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	}
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener 
	{
		 public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
		 {
			 
		 }
		 
		 public void onNothingSelected(AdapterView parent) 
		 {
		      // Do nothing.
		 }
	}
}
