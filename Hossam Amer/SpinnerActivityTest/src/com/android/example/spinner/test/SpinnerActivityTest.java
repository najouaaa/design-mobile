package com.android.example.spinner.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.android.example.spinner.SpinnerActivity;

public class SpinnerActivityTest extends
		ActivityInstrumentationTestCase2<SpinnerActivity> {
	
	private SpinnerActivity mActivity;
	private Spinner mSpinner;
	
	// For data provider
	private SpinnerAdapter mPlanetData;
	private String mSelection;
	private int mPos;
	
	public static final int ADAPTER_COUNT = 9;
	public static final int INITIAL_POSITION = 0;
	public static final int TEST_POSITION = 5;
	public static final int TEST_STATE_DESTROY_POSITION = 2;
	public static final String TEST_STATE_DESTROY_SELECTION = "Earth";
	public static final int TEST_STATE_PAUSE_POSITION = 4;
	public static final String TEST_STATE_PAUSE_SELECTION = "Jupiter";
	

	public SpinnerActivityTest()
	{
	    super("com.android.example.spinner", SpinnerActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		
		// Disable touch mood
		setActivityInitialTouchMode(false);
		
		// This line was missing!
		mActivity = this.getActivity();
		mSpinner = (Spinner) mActivity
							.findViewById(com.android.example.spinner.R.id.Spinner01);
		
		mPlanetData = mSpinner.getAdapter();
		
	}
	
	// Testing whether the app is initialized correctely
	public void testPreConditions()
	{
		assertTrue(mSpinner.getOnItemSelectedListener() != null);
		assertTrue (mPlanetData != null);
		assertEquals (mPlanetData.getCount(), ADAPTER_COUNT);
	}
	
	// Testing the View = get the focus + set selection ;)
	public void testSpinnerUI()
	{
		// Run the UI thread
		// Nested Classes :D
		
		mActivity.runOnUiThread
		(
				new Runnable() {
					
					public void run() {
						mSpinner.requestFocus();
						mSpinner.setSelection(INITIAL_POSITION);
					}//end of run
				}// end of Runnable instantiation
		);//end runUI
		
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
	    for (int i = 1; i <= TEST_POSITION; i++) {
	      this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
	    } // end of for loop
	    
	    //Pad down key
	    this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
	    
	    
	    //Check the current status of the spinner
	    mPos = mSpinner.getSelectedItemPosition();
	    mSelection = (String)mSpinner.getItemAtPosition(mPos);
	    TextView resultView =
	      (TextView) mActivity.findViewById(
	        com.android.example.spinner.R.id.SpinnerResult
	      );

	    String resultText = (String) resultView.getText();

	    assertEquals(resultText, mSelection);

	  } // end of testSpinnerUI() method definition
	
	//Testing Activity lifecycle
	public void testStateDestroy()
	{
		mActivity.setSpinnerPosition(TEST_STATE_DESTROY_POSITION);
		mActivity.setSpinnerSelection(TEST_STATE_DESTROY_SELECTION);
		
		// Kill and Restart
		mActivity.finish();
		mActivity = this.getActivity();
		
		int currentPosition = mActivity.getSpinnerPosition();
	    String currentSelection = mActivity.getSpinnerSelection();
	    
	    assertEquals(TEST_STATE_DESTROY_POSITION, currentPosition);
	    assertEquals(TEST_STATE_DESTROY_SELECTION, currentSelection);
	
	}
	
	// UI thread
	@UiThreadTest
    public void testStatePause() 
	{
		// Get the instrumentation object that is controlling the application under test. 
		// This is used later to invoke the onPause() and onResume() methods
	    Instrumentation mInstr = this.getInstrumentation();
	  
	    mActivity.setSpinnerPosition(TEST_STATE_PAUSE_POSITION);
	    mActivity.setSpinnerSelection(TEST_STATE_PAUSE_SELECTION);
	    
	    // To call the activity which currentely on pause
	    mInstr.callActivityOnPause(mActivity);
	    
	    mActivity.setSpinnerPosition(0);
	    mActivity.setSpinnerSelection("");
	 
	    // Resume the activity
	    mInstr.callActivityOnResume(mActivity);

	    int currentPosition = mActivity.getSpinnerPosition();
	    String currentSelection = mActivity.getSpinnerSelection();
	    
	    assertEquals(TEST_STATE_PAUSE_SELECTION, currentSelection);
	    assertEquals(TEST_STATE_PAUSE_POSITION, currentPosition);
	
	}	
}
