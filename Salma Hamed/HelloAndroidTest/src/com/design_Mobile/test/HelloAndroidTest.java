package com.design_Mobile.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.design_Mobile.HelloWorldActivity;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloWorldActivity> {

	 private HelloWorldActivity mActivity;
	    private TextView mView;
	    private String resourceString;
	
	public HelloAndroidTest() {
	      super("com.design_Mobile", HelloWorldActivity.class);
	    }
	
	 @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        mActivity = this.getActivity();
	        mView = (TextView) mActivity.findViewById(com.design_Mobile.R.id.textview);
	        resourceString = mActivity.getString(com.design_Mobile.R.string.hello);
	    }
	 
	 public void testPreconditions() {
	      assertNotNull(mView);
	    }
	 
	 public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
	    }
	 
	 
}
