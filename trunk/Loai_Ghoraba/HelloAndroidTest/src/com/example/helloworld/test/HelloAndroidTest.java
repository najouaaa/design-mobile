package com.example.helloworld.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.helloworld.HelloworldActivity;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloworldActivity> {
	private HelloworldActivity mActivity;
	private TextView mView;
	private String resourceString;

	public HelloAndroidTest() {
		super("com.example.helloandroid", HelloworldActivity.class);
	}

	public void setUp() {
		mActivity = this.getActivity();
		mView = (TextView) mActivity
				.findViewById(com.example.helloworld.R.id.textview);
		resourceString = mActivity
				.getString(com.example.helloworld.R.string.hello);
	}

	public void testPreconditions() {
		assertNotNull(mView);
	}
	public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
	    }
}
