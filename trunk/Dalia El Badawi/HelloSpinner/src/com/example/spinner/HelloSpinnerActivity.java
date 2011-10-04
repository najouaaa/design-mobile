/**
 * 
Author: Dalia El Badawi
Created: 04/10/2011
 *
**/
package com.example.spinner;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class HelloSpinnerActivity extends Activity {
    /** Called when the activity is first created. */
	protected int mPos;
    protected String mSelection;
    
    /**
     *  The initial position of the spinner when it is first installed.
     */
    public static final int DEFAULT_POSITION = 2;

    /**
     * The name of a properties file that stores the position and
     * selection when the activity is not loaded.
     */
    public static final String PREFERENCES_FILE = "SpinnerPrefs";

    /**
     * These values are used to read and write the properties file.
     * PROPERTY_DELIMITER delimits the key and value in a Java properties file.
     * The "marker" strings are used to write the properties into the file
     */
    public static final String PROPERTY_DELIMITER = "=";

    /**
     * The key or label for "position" in the preferences file
     */
    public static final String POSITION_KEY = "Position";

    /**
     * The key or label for "selection" in the preferences file
     */
    public static final String SELECTION_KEY = "Selection";

    public static final String POSITION_MARKER =
            POSITION_KEY + PROPERTY_DELIMITER;

    public static final String SELECTION_MARKER =
            SELECTION_KEY + PROPERTY_DELIMITER;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    Spinner spinner = (Spinner) findViewById(R.id.spinner);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.planets_array, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
	    //spinner.setOnItemSelectedListener(null);
	}
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener {

	    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
	    	HelloSpinnerActivity.this.mPos = pos;
            HelloSpinnerActivity.this.mSelection = parent.getItemAtPosition(pos).toString();
            
	      Toast.makeText(parent.getContext(), "The planet is " +
	          parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
	      TextView resultView =
	 	      (TextView) findViewById(com.example.spinner.R.id.SpinnerResult
	 	      );
	      resultView.setText("The planet is " +
	          parent.getItemAtPosition(pos).toString());
	    }

	    public void onNothingSelected(AdapterView parent) {
	      // Do nothing.
	    }
	}

	public int getSpinnerPosition() {
        return this.mPos;
    }

    public void setSpinnerPosition(int pos) {
        this.mPos = pos;
    }

    public String getSpinnerSelection() {
        return this.mSelection;
    }

    public void setSpinnerSelection(String selection) {
        this.mSelection = selection;
    }
    
    @Override
    public void onResume() {

        /*
         * an override to onResume() must call the super constructor first.
         */

        super.onResume();

        /*
         * Try to read the preferences file. If not found, set the state to the desired initial
         * values.
         */

        if (!readInstanceState(this)) setInitialState();

        /*
         * Set the spinner to the current state.
         */

        Spinner restoreSpinner = (Spinner)findViewById(R.id.spinner);
        restoreSpinner.setSelection(getSpinnerPosition());

    }

    /**
     * Store the current state of the spinner (which item is selected, and the value of that item).
     * Since onPause() is always called when an Activity is about to be hidden, even if it is about
     * to be destroyed, it is the best place to save state.
     *
     * Attempt to write the state to the preferences file. If this fails, notify the user.
     *
     * @see android.app.Activity#onPause()
     */
    @Override
    public void onPause() {

        /*
         * an override to onPause() must call the super constructor first.
         */

        super.onPause();

        /*
         * Save the state to the preferences file. If it fails, display a Toast, noting the failure.
         */

        if (!writeInstanceState(this)) {
             Toast.makeText(this,
                     "Failed to write state!", Toast.LENGTH_LONG).show();
          }
    }
    
    /**
     * Sets the initial state of the spinner when the application is first run.
     */
    public void setInitialState() {

        this.mPos = DEFAULT_POSITION;

    }

    /**
     * Read the previous state of the spinner from the preferences file
     * @param c - The Activity's Context
     */
    public boolean readInstanceState(Context c) {

        /*
         * The preferences are stored in a SharedPreferences file. The abstract implementation of
         * SharedPreferences is a "file" containing a hashmap. All instances of an application
         * share the same instance of this file, which means that all instances of an application
         * share the same preference settings.
         */

        /*
         * Get the SharedPreferences object for this application
         */

        SharedPreferences p = c.getSharedPreferences(PREFERENCES_FILE, MODE_WORLD_READABLE);
        /*
         * Get the position and value of the spinner from the file, or a default value if the
         * key-value pair does not exist.
         */
        this.mPos = p.getInt(POSITION_KEY, HelloSpinnerActivity.DEFAULT_POSITION);
        this.mSelection = p.getString(SELECTION_KEY, "");

        /*
         * SharedPreferences doesn't fail if the code tries to get a non-existent key. The
         * most straightforward way to indicate success is to return the results of a test that
         * SharedPreferences contained the position key.
         */

          return (p.contains(POSITION_KEY));

        }

    /**
     * Write the application's current state to a properties repository.
     * @param c - The Activity's Context
     *
     */
    public boolean writeInstanceState(Context c) {

        /*
         * Get the SharedPreferences object for this application
         */

        SharedPreferences p =
                c.getSharedPreferences(HelloSpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);

        /*
         * Get the editor for this object. The editor interface abstracts the implementation of
         * updating the SharedPreferences object.
         */

        SharedPreferences.Editor e = p.edit();

        /*
         * Write the keys and values to the Editor
         */

        e.putInt(POSITION_KEY, this.mPos);
        e.putString(SELECTION_KEY, this.mSelection);

        /*
         * Commit the changes. Return the result of the commit. The commit fails if Android
         * failed to commit the changes to persistent storage.
         */

        return (e.commit());

    }


	
}