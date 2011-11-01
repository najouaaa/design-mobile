package wassalt.app;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.TabHost;

public class WassaltActivity extends TabActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); 
        TabHost tabHost = getTabHost(); 
        TabHost.TabSpec spec; 
        Intent intent; 

        intent = new Intent().setClass(this, InComingActivity.class);

        spec = tabHost.newTabSpec("Incoming").setIndicator("Incoming",
                          res.getDrawable(R.drawable.ic_tab_grid_view))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, OutGoingActivity.class);

        spec = tabHost.newTabSpec("Outgoing").setIndicator("Outgoing",
                          res.getDrawable(R.drawable.ic_tab_grid_view))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(1);
    }
}