package com.example.horoscope;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TabViewActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_view);

		Resources res = getResources();
		TabHost tabHost = getTabHost();

		Intent intent = new Intent().setClass(this, ListViewActivity.class);
		TabHost.TabSpec spec = tabHost.newTabSpec("list")
				.setIndicator("List", res.getDrawable(R.drawable.list))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, TableLayoutActivity.class);
		spec = tabHost.newTabSpec("Table")
				.setIndicator("Table", res.getDrawable(R.drawable.ic_tabs))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, GridViewActivity.class);
		spec = tabHost.newTabSpec("grid")
				.setIndicator("Grid", res.getDrawable(R.drawable.grid))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, RelativeLayoutActivity.class);
		spec = tabHost.newTabSpec("relative")
				.setIndicator("Relative", res.getDrawable(R.drawable.relative))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}
}
