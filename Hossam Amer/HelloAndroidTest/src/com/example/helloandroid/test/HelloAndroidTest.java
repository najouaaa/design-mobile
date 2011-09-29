package com.example.helloandroid.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.helloandroid.HelloAndroid;


//Instrumentation allows to make call backs inside the code

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloAndroid> {
	
	private HelloAndroid mActivity;
	private TextView mView;
	private String resourceString; 
	
	public HelloAndroidTest()
	{
	     super("com.example.helloandroid", HelloAndroid.class);
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
        mActivity = this.getActivity();
        mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview);
        resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);

	}
	
	// Testing the preconditions of the app, avoiding a null pointer exception
	public void testPreconditions ()
	{
		assertNotNull(mView);
	}
	
	
	// Assert the text equality
	public void testText()
	{
		assertEquals(resourceString, mView.getText().toString());
	}
	
}
