/***
 * Author: Dina Helal
 */

package com.example.helloandroid.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.helloandroid.Hello_AndroidActivity;
import android.widget.TextView;

public class HelloAndroidTest extends ActivityInstrumentationTestCase2<Hello_AndroidActivity> {

	private Hello_AndroidActivity mActivity; // the activity being tested
	private TextView mView;                  // the activity's TextView (the only view)
	private String resourceString;			 // text string in the resource file of the tested activity

	/**
	 * Constructor
	 */
	public HelloAndroidTest() {
	      super("com.example.helloandroid", Hello_AndroidActivity.class);
	    }			

	/***
	 * initialize variables and prepare the test environment
	 */
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview);
        resourceString = mActivity.getString(com.example.helloandroid.R.string.hello);
    }
	
	/***
	 * checks the initial application conditions prior to executing other tests
	 */
	public void testPreconditions() {
	      assertNotNull(mView);
	    }
	
	/***
	 * check whether the target TextView is displaying the expected text
	 */
	public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
	    }
	
	
}
