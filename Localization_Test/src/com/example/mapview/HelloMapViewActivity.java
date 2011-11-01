package com.example.mapview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class HelloMapViewActivity extends MapActivity {
    /** Called when the activity is first created. */
	
	LinearLayout linearLayout;
	MapView mapView;
	List<Overlay> mapOverlays;
	Drawable drawable;
	HelloItemizedOverlay itemizedOverlay;
	String filename;
	FileOutputStream fos;
	FileInputStream fis;
	int filecontent;
	Scanner scanner;
	double batteryLevelPercentage;
	
	
	final String MODE_GPS = "gps";
	/**
	 * string representation of skyhooker mode in the application
	 */
	final String MODE_SKYHOOKER = "skyhooker";
	
	/**
	 * Indicates app settings of service type used for detecting the location (GPS or Skyhooker)
	 */
	String type;
	/**
	 * Indicates app settings of the number of seconds between different checks for new location
	 */
	int frequency;
	/**
	 * Indicates app settings of the ... (DUNNO)
	 */
	int distance;
	
	/**
	 * Indicates location result - 1st coordinate
	 */
	double latitude;
	/**
	 * Indicates location result - 2nd coordinate
	 */
	double longitude;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        filename = "hello_file";
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new HelloItemizedOverlay(drawable);
        
        GeoPoint point = new GeoPoint(19240000,-99120000);
        addLocation(point);
     
        GeoPoint point2 = new GeoPoint(35410000, 139460000);
        addLocation(point2);
        
        mapOverlays.add(itemizedOverlay);
       
       runApp();
        
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    public void addLocation(GeoPoint point){
    	
    	OverlayItem overlayitem = new OverlayItem(point, "", "");
        itemizedOverlay.addOverlay(overlayitem);
    	
    }
    
	 /**
	  * Called whenever the "settings" button is clicked
	  * to open settings preference menu
	  * @param v button
	  */
	 public void onClick_button_settings(View v) {
		 startActivity(new Intent(this, PreferencesActivity.class));
    }// end onClick_button_settings	 
	 
	 
	 /**
	  * Used as the main back end for the application engine.	  * 
	  */
	 private void runApp(){
		 
		 // Check if the application should collect information or not 
		 if (isOpenService()){
		
			 Log.e("7as7as: ", "The app is ENABLED!");
			 
			 // Fetch data settings from the preferences
			 getAppSettings();
			 
			 // Inspect mode to choose location detection engine
			 if (this.type == MODE_GPS){
				 detectLocationUsingGps();
			 }// end if : detect location using GPS/AGPS
			 else if (this.type == MODE_SKYHOOKER){
				 detectLocationUsingSkyhooker();
			 }// end else : detect location using Skyhooker SDK
			 
			 // Get battery level
			 getBatteryLevel();
			 
			 // Display on the map (create point + display on the map)
			 displayLocationOnMap();
			 
			 // Write the fetched data in the file (method + location + battery consumption)
//			 writeDataToFile();
		 }// end if : application is in detection mode
		 else{
			 
			 Log.e("7as7as: ", "The app is disabled");
//			 Toast.makeText(this, "The app is disabled!", 1).show();
		 }
		 
	 }// end runApp
	 
	 /**
	  * Used to get the different settings to detect location like
	  * frequency , type and distance
	  */
	 private void getAppSettings(){
		 
		 // Open the shared preferences location in the android phone
		 SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		 
		 // Get frequency as a string. In case not found , default is 2 min 
		 String frequency_string = sharedPrefs.getString("input_frequency", "120");
		 // Get distance as a string. In case not found, default is 100 meter
		 String distance_string = sharedPrefs.getString("input_distance", "100");
		 
		 try{
			 // Parse frequency 
			 this.frequency = Integer.parseInt(frequency_string);			 
		 }catch(NumberFormatException nEx1){
			 this.frequency = 120;
		 }// end catch : input was not a number -> set to default
		 
		 try{
			 // Parse  distance
			 this.distance = Integer.parseInt(distance_string);			 
		 }catch(NumberFormatException nEx2){
			 this.distance = 100;
		 }// end catch : input was not a number -> set to default
		
		 // Get type of service to be activated. If not found, default is "gps"
		 this.type = sharedPrefs.getString("input_type", "gps");
		 
		 if ((!this.type.equalsIgnoreCase(MODE_GPS)) && (!this.type.equalsIgnoreCase(MODE_SKYHOOKER))){
			 this.type = "gps";
		 }// end if : in case of mistake in input -> choose default: gps
		 
	 }// end getAppSettings

	 /**
	  * Used to detect if location should be detected or not (open/close app)
	  * @return true: detect location , false: stop service
	  */
	 private boolean isOpenService(){	 
		 // Open the shared preferences location in the android phone
		 SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		 // Get the status from the preferences. In case nothing is set, default is false
		 return sharedPrefs.getBoolean("input_activateApp", false);		 
	 }// end isOpenService
	
	 /**
	  * Used to detect the current location using the GPS / AGPS
	  */
	 private void detectLocationUsingGps(){
		 
		 // TODO Hossam please implement this method
		 
		 /*The method must set latitude and longitude instance parameters are the end*/
		 
		 // Location results detected
		 this.latitude = 0;
		 this.longitude=0;
		 
	 }// end detectLocationUsingGps
	 
	 /**
	  * Used to detect the current location using the Skyhooker SDK
	  */
	 private void detectLocationUsingSkyhooker(){
		 
		 // TODO Mohsen please implement this method
		 
		 /*The method must set latitude and longitude instance parameters are the end*/
		 
		 // Location results detected
		 this.latitude = 0;
		 this.longitude=0;		 
	 }// end detectLocationUsingGps
	 
	 /**
	  * Used to get the current battery level of the machine running the app
	  * @return percentage of remaining battery in the machine running the app
	  */
	 private void getBatteryLevel(){
		 
		BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() 
		{
		
			
		public void onReceive(Context context, Intent intent) {
				context.unregisterReceiver(this);
		                int rawlevel = intent.getIntExtra("level", -1);
		                int scale = intent.getIntExtra("scale", -1);
		                batteryLevelPercentage = -1;
		                if (rawlevel >= 0 && scale > 0) {
		                	
		                    batteryLevelPercentage =  (rawlevel * 100) / (1.0*scale);
		                    writeDataToFile();
		                }
		            }
		        };
		        
		        
		        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		        registerReceiver(batteryLevelReceiver, batteryLevelFilter);
		    	 
	 }// end getBatteryLevel
	 
	 /**
	  * Used to display the detected location by the engine on the map as a 
	  * visible point
	  */
	 private void displayLocationOnMap(){
		 
		 // TODO maged please implement it
		 
		 // Create GeoPoint from the longitude and latitude instance parameters
		 		 
		 // Display on the map
	 }// end displayLocationOnMap

	 /**
	  * Used to write the different data to the file for comparing different methods
	  * later
	  * @param batteryLevel remaining charge percentage in the machine running the app
	  */
	 private void writeDataToFile(){

		 /* You will find all the data you need here. I dunno what format will
		  * you use:
		  * 
		  * batteryLevel: input from method
		  * Location: longitude and latitude instance parameters
		  * method used: type instance parameter
		  * distance : distance instance parameter
		  * 
		  * */
		 
		 try{

				fos = openFileOutput(filename, Context.MODE_PRIVATE);
				String text = " " +type+ " "+longitude + " "+latitude+" "+ batteryLevelPercentage+"\n"; 
		        fos.write(text.getBytes());
		        fos.close();
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

//			// #7as7as Reading!
//			
//			try {
//				fis = openFileInput(filename);
//				scanner = new Scanner(fis);
//				filecontent = fis.read();
//				String text = "";
//				
//				// Empty the textbox
//				Log.e("7as7as Reading: ", "Now ");
//				
//				while (scanner.hasNextLine())
//					text += scanner.nextLine();
//
//				
//				Log.e("7as7as Reading: ", text);
//				fis.close();
//				scanner.close();
//			
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
	 }// end writeDataToFile
 
	 
}