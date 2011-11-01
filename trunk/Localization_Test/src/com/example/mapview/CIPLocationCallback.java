package com.example.mapview;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.skyhookwireless.wps.IPLocation;
import com.skyhookwireless.wps.WPSContinuation;
import com.skyhookwireless.wps.WPSReturnCode;
// working with EMULATOR
public class CIPLocationCallback implements com.skyhookwireless.wps.IPLocationCallback
{
Handler handler;
public  CIPLocationCallback (Handler handler){
this.handler = handler;
}
// What the application should do after it's done
public void done()
{
// after done() returns, you can make more WPS calls.
Log.e("<<DONE>>", "adios");
}
// What the application should do if an error occurs
public WPSContinuation handleError(WPSReturnCode error)
{
//handleWPSError(error); // you'll implement handleWPSError()
Log.e("<<ERROR>>", "error in handleError " );
Message msg = handler.obtainMessage();

 
msg.arg1 = 777; //out of the range 0..360
msg.arg2 = 888; //to be recognized as an error
handler.sendMessage(msg);
// To retry the location call on error use WPS_CONTINUE,
// otherwise return WPS_STOP
return WPSContinuation.WPS_STOP;
}
// ----------------------------------------------------------------------
public void handleIPLocation(IPLocation location) {
Log.e("<<IP-LOCATION>>", "latitude: " + location.getLatitude());
Log.e("<<IP-LOCATION>>", "longitude: " + location.getLongitude());
Log.e("<<IP-LOCATION>>", "address: " + location.getStreetAddress());
Log.e("<<IP-LOCATION>>", "time: " + location.getTime() );
Log.e("<<IP-LOCATION>>", "altitude: " + location.getAltitude());
Log.e("<<IP-LOCATION>>", "IP: " + location.getIP() );
Message msg = handler.obtainMessage();
msg.obj = (IPLocation)location;
handler.sendMessage(msg);
}
}
