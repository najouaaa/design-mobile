package com.android.example.spinner.test;

import com.android.example.spinner.SpinnerActivity;

import android.R.id;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class SpinnerActivityTest extends
		ActivityInstrumentationTestCase2<SpinnerActivity> {

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

	public SpinnerActivityTest() {
		super("import com.android.example.spinner", SpinnerActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);// enables the input in the
											// application
		mActivity = getActivity(); // get the working activity
		mSpinner = (Spinner) mActivity
				.findViewById(com.android.example.spinner.R.id.Spinner01);// getting
																			// spinner
																			// UI
		mPlanetData = mSpinner.getAdapter();
	}

	public void testPreConditions() {
		assertTrue(mSpinner.getOnItemSelectedListener() != null);
		assertTrue(mPlanetData != null);
		assertEquals(mPlanetData.getCount(), ADAPTER_COUNT);
	}

	public void testSpinnerUI() {

		mActivity.runOnUiThread(new Runnable() {
			public void run() {
				mSpinner.requestFocus();
				mSpinner.setSelection(INITIAL_POSITION);
			}
		});
		// navigate through the list
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		for (int i = 1; i <= TEST_POSITION; i++) {
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		} // end of for loop

		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		mPos = mSpinner.getSelectedItemPosition();
		mSelection = (String) mSpinner.getItemAtPosition(mPos);
		TextView resultView = (TextView) mActivity
				.findViewById(com.android.example.spinner.R.id.SpinnerResult);

		String resultText = (String) resultView.getText();

		assertEquals(resultText, mSelection);

	}

	public void testStateDestroy() {
		// setting the values before close

		mActivity.setSpinnerPosition(TEST_STATE_DESTROY_POSITION);
		mActivity.setSpinnerSelection(TEST_STATE_DESTROY_SELECTION);
		// close app
		mActivity.finish();
		// reopen
		mActivity = this.getActivity();
		// getting values after closing
		int currentPosition = mActivity.getSpinnerPosition();
		String currentSelection = mActivity.getSpinnerSelection();
		assertEquals(TEST_STATE_DESTROY_POSITION, currentPosition);
		assertEquals(TEST_STATE_DESTROY_SELECTION, currentSelection);
	}

	@UiThreadTest
	public void testStatePause() {
		Instrumentation mInstr = this.getInstrumentation();
		// set the position
		mActivity.setSpinnerPosition(TEST_STATE_PAUSE_POSITION);
		mActivity.setSpinnerSelection(TEST_STATE_PAUSE_SELECTION);
		// pause
		mInstr.callActivityOnPause(mActivity);
		// force values
		mActivity.setSpinnerPosition(0);
		mActivity.setSpinnerSelection("");
		// Resume
		mInstr.callActivityOnResume(mActivity);
		int currentPosition = mActivity.getSpinnerPosition();
		String currentSelection = mActivity.getSpinnerSelection();
		assertEquals(TEST_STATE_PAUSE_POSITION, currentPosition);
		assertEquals(TEST_STATE_PAUSE_SELECTION, currentSelection);
	}

}
