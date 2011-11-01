package wassalt.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{
	   
	private Context mContext;
	private boolean incoming;
	private String[] InTexts = {"Aya", "Iman", "Dalia"};
	private String[] InStatus = {"Accepted", "Pending", "Rejected"};
	private String[] OutTexts = {"Fatma", "Gad", "Loai"};
	private String[] OutStatus = {"Accepted", "Pending", "Accepted"};

	    public ListAdapter(Context c, boolean in) {
	        mContext = c;
	        incoming = in;
	    }

	    public int getCount() {
	        if(incoming)
	        	return InTexts.length;
	        else
	        	return OutTexts.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {

	    	View row;
	        if(convertView == null) {  // if it's not recycled, initialize some attributes
	        	LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            row = inflater.inflate(R.layout.list_item, parent, false);
	            TextView name = (TextView)row.findViewById(R.id.contact_name);
	            TextView status= (TextView)row.findViewById(R.id.notification_status);
	            if(incoming)
	            {
	            	name.setText(InTexts[position]);
		            status.setText(InStatus[position]);
	            }
	            else
	            {
	            	name.setText(OutTexts[position]);
		            status.setText(OutStatus[position]);
	            }
	        } 
	        else 
	        {
	            row = (View) convertView;
	        }
	        return row;
	    }

	}
