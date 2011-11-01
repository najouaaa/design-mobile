package wassalt.app;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class InComingActivity extends ListActivity{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setListAdapter(new ListAdapter(this, true));

      ListView lv = getListView();
      lv.setTextFilterEnabled(true);
    }
}
