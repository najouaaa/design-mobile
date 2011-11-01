package com.test;

import android.os.Handler;

public class skyhook {
	
	private Handler _handler;
    private static final int LOCATION_MESSAGE = 1;
    private static final int ERROR_MESSAGE = 2;
    private static final int DONE_MESSAGE = 3;
 //   private final MyLocationCallback _callback = new MyLocationCallback();

//	if(skyhook){
//	 WPS wps = new WPS(this);
//    WPSAuthentication auth = new WPSAuthentication("salma_7amed", "German university in cairo");
//    wps.getIPLocation(auth,WPSStreetAddressLookup.WPS_NO_STREET_ADDRESS_LOOKUP,_callback);
//    }
//	else{
	//
//	 private void setUIHandler()
//	    {
//	        _handler = new Handler()
//	        {
//	            @Override
//	            public void handleMessage(final Message msg)
//	            {
//	                switch (msg.what)
//	                {
//	                case LOCATION_MESSAGE:
//	                    final Location location = (Location) msg.obj;
//	                    txtMsg.setText(location.toString());
//	                    return;
//	                case ERROR_MESSAGE:
//	                	txtMsg.setText(((WPSReturnCode) msg.obj).name());
//	                    return;
//	                case DONE_MESSAGE:
//	                    skyhook = false;
//	                }
//	            }
//	        };
//	    }
//	
	
	
//	 private class MyLocationCallback implements IPLocationCallback {
//		 
//    public void done()
//    {
//        // tell the UI thread to re-enable the buttons
//        _handler.sendMessage(_handler.obtainMessage(DONE_MESSAGE));
//    }
//
//    public WPSContinuation handleError(final WPSReturnCode error)
//    {
//        // send a message to display the error
//        _handler.sendMessage(_handler.obtainMessage(ERROR_MESSAGE,
//                                                    error));
//        // return WPS_STOP if the user pressed the Stop button
//            return WPSContinuation.WPS_STOP;
//    }
//
//    public void handleIPLocation(final IPLocation location)
//    {
//        // send a message to display the location
//        _handler.sendMessage(_handler.obtainMessage(LOCATION_MESSAGE, location));
//    }
//
//}
//
	
	
}
