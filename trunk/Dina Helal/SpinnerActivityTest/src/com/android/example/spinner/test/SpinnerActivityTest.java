/***
 * Author: Dina Helal
 */

package com.android.example.spinner.test;

import com.android.example.spinner.SpinnerActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.view.KeyEvent;
import android.widget.TextView;
import android.app.Instrumentation;
import android.test.UiThreadTest;

public class SpinnerActivityTest extends ActivityInstrumentationTestCase2<SpinnerActivity> {

	private SpinnerActivity mActivity;
	private Spinner mSpinner;
	private SpinnerAdapter mPlanetData;
	public static final int ADAPTER_COUNT = 9;
	public static final int INITIAL_POSITION = 0;
	public static final int TEST_POSITION = 5;
	private String mSelection;
	private int mPos;
	public static final int TEST_STATE_DESTROY_POSITION = 2;
	public static final String TEST_STATE_DESTROY_SELECTION = "Earth";
	public static final int TEST_STATE_PAUSE_POSITION = 4;
	public static final String TEST_STATE_PAUSE_SELECTION = "Jupiter";
	 
	/***
	 * Constructor
	 */
	public SpinnerActivityTest() 
	{
		super("com.android.example.spinner", SpinnerActivity.class);
	} 
	
	/***
	 * Initialize variables and clean up from previous tests
	 */
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
		mSpinner = (Spinner) mActivity.findViewById(com.android.example.spinner.R.id.Spinner01);
		mPlanetData = mSpinner.getAdapter();
	}
	
	/***
	 * Verifies that the application under test is initialized correctly
	 */
	public void testPreConditions() 
	{
		assertTrue(mSpinner.getOnItemSelectedListener() != null);
		assertTrue(mPlanetData != null);
		assertEquals(mPlanetData.getCount(),ADAPTER_COUNT);
	}
	 
	/***
	 * Test UI by sending key requests
	 */
	public void testSpinnerUI() 
	{
		mActivity.runOnUiThread(
		new Runnable() 
		{
			public void run() 
			{
				mSpinner.requestFocus();
				mSpinner.setSelection(INITIAL_POSITION);
			}
		}); 
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		for (int i = 1; i <= TEST_POSITION; i++) 
		{
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		}
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);    
		mPos = mSpinner.getSelectedItemPosition();
		mSelection = (String)mSpinner.getItemAtPosition(mPos);
		TextView resultView = (TextView) mActivity.findViewById(com.android.example.spinner.R.id.SpinnerResult);
		String resultText = (String) resultView.getText();
		assertEquals(resultText,mSelection);
	}
	
	/***
	 * Verify that SpinnerActivity maintains its state when it is terminated then restarted
	 */
	public void testStateDestroy() 
	{
		mActivity.setSpinnerPosition(TEST_STATE_DESTROY_POSITION);
		mActivity.setSpinnerSelection(TEST_STATE_DESTROY_SELECTION);
		mActivity.finish();
		mActivity = this.getActivity();
		int currentPosition = mActivity.getSpinnerPosition();
		String currentSelection = mActivity.getSpinnerSelection();
		assertEquals(TEST_STATE_DESTROY_POSITION, currentPosition);
		assertEquals(TEST_STATE_DESTROY_SELECTION, currentSelection);
	}

	/***
	 * Verify that SpinnerActivity maintains its state when it is paused then resumed
	 */
	@UiThreadTest
	public void testStatePause() 
	{
		Instrumentation mInstr = this.getInstrumentation();
		mActivity.setSpinnerPosition(TEST_STATE_PAUSE_POSITION);
		mActivity.setSpinnerSelection(TEST_STATE_PAUSE_SELECTION);
		mInstr.callActivityOnPause(mActivity);
		mActivity.setSpinnerPosition(0);
		mActivity.setSpinnerSelection("");
		mInstr.callActivityOnResume(mActivity);
		int currentPosition = mActivity.getSpinnerPosition();
		String currentSelection = mActivity.getSpinnerSelection();
		assertEquals(TEST_STATE_PAUSE_POSITION,currentPosition);
		assertEquals(TEST_STATE_PAUSE_SELECTION,currentSelection);
	}
}
