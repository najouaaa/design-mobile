package com.example.helloViews;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TabViewActivity extends TabActivity {
    /** Called when the activity is first created. */
	
	/**keyword used to send the value of animal from intent to the corresponding activity*/
	public static final String ANIMAL_KEY = "animal";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources();
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, RelativeViewActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("relative_view").setIndicator("Relative View",  
				res.getDrawable(R.drawable.relativexml))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, ListViewActivity.class);
        spec = tabHost.newTabSpec("list_view").setIndicator("List View",  
        						res.getDrawable(R.drawable.listxml))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, GridViewActivity.class);
        spec = tabHost.newTabSpec("grid_view").setIndicator("Grid View", 
        						res.getDrawable(R.drawable.gridxml))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, TableViewActivity.class);
        spec = tabHost.newTabSpec("table_view").setIndicator("Table View",  
				res.getDrawable(R.drawable.tablexml))
                      .setContent(intent);
        tabHost.addTab(spec);


        tabHost.setCurrentTab(0);
    }
}