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

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, HoroscopesList.class);
        spec = tabHost.newTabSpec("list").setIndicator("",
                res.getDrawable(R.drawable.layout_icon))
            .setContent(intent);

        // Initialize a TabSpec for each tab and add it to the TabHost
        tabHost.addTab(spec);
      
        intent = new Intent().setClass(this, HoroscopeGrid.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("grid").setIndicator("",
                res.getDrawable(R.drawable.layout_icon))
            .setContent(intent);
        tabHost.addTab(spec);
      
        intent = new Intent().setClass(this, HoroscopeSearch.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("search").setIndicator("",
                res.getDrawable(R.drawable.layout_icon))
            .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(0);
    }

}
