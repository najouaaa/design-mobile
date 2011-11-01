package com.gpsmap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GPS_UIActivity extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
        
        private boolean toggle = true;
        private Button start_end;
        private EditText frequency;
        private EditText distance;
        private Spinner type;
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_controls);
        
        //************       Spinner      ***************
        
        type = (Spinner)findViewById(R.id.types);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.avail_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        
        //************       Text Boxes   **************
        
        frequency = (EditText)findViewById(R.id.frequency);
        distance = (EditText)findViewById(R.id.distance);
        
        //************        Button      **************
        
        start_end = (Button)findViewById(R.id.start_end);
        start_end.setOnClickListener(this);

    }
        
        public void onClick(View v) {
                toggle = !toggle;               
                String str = "";
                if(toggle)
                {
                        String typ = type.getSelectedItem().toString();
                        String freq = frequency.getText().toString();
                        String dist = distance.getText().toString();
                        
                        start_end.setText("Start");
                        str = "Starting "+typ+
                                        " service with a frequency of "+freq+
                                        " and distance "+dist+"!!";
                        
                        /*
                         * Intent intent;
                         * if(typ.equals("GPS")
                         *              intent = new Intent().setClass(GPS_UIActivity.this, [GPS Class]);
                         * else
                         * {
                         *              if(typ.equals("AGPS"))
                         *                      intent = new Intent().setClass(GPS_UIActivity.this, [AGPS Class]);
                         *              else
                         *                      intent = new Intent().setClass(GPS_UIActivity.this, [Skyhook Class]);
                         * }
                         * startActivity(intent);
                        */
                        type.setEnabled(false);
                        frequency.setEnabled(false);
                        distance.setEnabled(false);
                }
                else
                {
                        start_end.setText("End");
                        str = "Ending service!!";
                        type.setEnabled(true);
                        frequency.setEnabled(true);
                        distance.setEnabled(true);
                }
                Toast.makeText(this, str, 0).show();
        }
}