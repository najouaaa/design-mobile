package com.example.helloandroid.test;

import com.example.helloandroid.HelloAndroid;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloAndroid> {
	
	private HelloAndroid mActivity;
	private TextView mView;    
	private String resourceString;
	
	
	public HelloAndroidTest() {
		super("com.example.helloandroid", HelloAndroid.class);
	}
	
	
	  @Override  
	  //initializes the variables and prepares the test environment
	  protected void setUp() throws Exception {        
		  super.setUp();        
		  mActivity = this.getActivity();        
		  mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview);        
		  resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);    
	 }
	  
	  //checks the initial application conditions prior to executing other tests
	  public void testPreconditions() {      
		  assertNotNull(mView);    
	 }
	  
	  //checks whether the target TextView is displaying the expected text. 
	  public void testText() {      
		  assertEquals(resourceString,(String)mView.getText());    
	  }

}
