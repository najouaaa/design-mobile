package com.example.myTest.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.myTest.AndroidTestActivity;



public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<AndroidTestActivity> {
	
	private AndroidTestActivity mActivity;
	private TextView mView;
	private String resourceString;
	
	public HelloAndroidTest() {
		super("com.example.myTest", AndroidTestActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mView = (TextView) mActivity
				.findViewById(com.example.myTest.R.id.textview);
		resourceString = mActivity
				.getString(com.example.myTest.R.string.hello);
	}
	
	public void testPreconditions() {
	      assertNotNull(mView);
	    }
	
	public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
	    }

}