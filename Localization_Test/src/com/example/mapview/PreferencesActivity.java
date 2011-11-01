package com.example.mapview;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PreferencesActivity extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.preferences);     
    }  
        /**
         * Called on clicking the MENU button to navigate back
         * to the map view
         */
      @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            menu.add(Menu.NONE, 0, 0, "Show map");
            return super.onCreateOptionsMenu(menu);
        }

      /**
       * Used to switch back to the map view
       */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case 0:
                    startActivity(new Intent(this, HelloMapViewActivity.class));
                    return true;
            }
            return false;
        } 
        
   

    
}