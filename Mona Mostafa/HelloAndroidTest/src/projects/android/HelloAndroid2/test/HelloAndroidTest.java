package projects.android.HelloAndroid2.test;
import projects.android.HelloAndroid2.HelloAndroid2Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class HelloAndroidTest extends
		ActivityInstrumentationTestCase2<HelloAndroid2Activity> {

	private HelloAndroid2Activity mActivity;
    private TextView mView;
    private String resourceString;
    
	public HelloAndroidTest() {
	    super("projects.android.HelloAndroid2", HelloAndroid2Activity.class);
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (TextView) mActivity.findViewById(projects.android.HelloAndroid2.R.id.textview);
        resourceString = mActivity.getString(projects.android.HelloAndroid2.R.string.hello);
    }
	
	public void testPreconditions() {
	      assertNotNull(mView);
	    }
	
	public void testText() {
	      assertEquals(resourceString,(String)mView.getText());
	    }
}

