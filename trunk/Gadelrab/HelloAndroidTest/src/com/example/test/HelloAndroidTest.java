package com.example.test;

import com.example.HelloAndroidActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloAndroidActivity> {

	private HelloAndroidActivity mActivity;
	private TextView mView;
	private String resourceString;

	public HelloAndroidTest() {
		super("com.example", HelloAndroidActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		mView = (TextView) mActivity.findViewById(com.example.R.id.textview);
		resourceString = mActivity.getString(com.example.R.string.hello);
	}

	public void testPreconditions() {
		assertNotNull(mView);
	}

	public void testText() {
		assertEquals(resourceString, (String) mView.getText());
	}
	
}
