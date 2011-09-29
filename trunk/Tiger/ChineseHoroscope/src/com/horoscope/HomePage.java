package com.horoscope;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * 
 * @author Rana
 *
 */
public class HomePage extends TabActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch the horoscopesList activity
        intent = new Intent().setClass(this, HoroscopesList.class);
        // Initialize tab spec
        spec = tabHost.newTabSpec("list").setIndicator("",
                res.getDrawable(R.drawable.list_view_state))
            .setContent(intent);

        // Add tabspec to the TabHost
        tabHost.addTab(spec);
      
        intent = new Intent().setClass(this, HoroscopeGrid.class);

        // Same as done above is repeated for the rest of the views; grid and search
        spec = tabHost.newTabSpec("grid").setIndicator("",
                res.getDrawable(R.drawable.grid_view_state))
            .setContent(intent);
        tabHost.addTab(spec);
      
        intent = new Intent().setClass(this, HoroscopeSearch.class);


        spec = tabHost.newTabSpec("search").setIndicator("",
                res.getDrawable(R.drawable.search_view_state))
            .setContent(intent);
        tabHost.addTab(spec);
        
        //Set the open tab to be the first tab which is the list view
        tabHost.setCurrentTab(0);
    }

}
