package com.fixedd.AndroidTrimet;

import org.apache.http.client.methods.HttpGet;
import android.location.Location;
import com.fixedd.AndroidTrimet.tasks.ArrivalsTask;
import com.fixedd.AndroidTrimet.tasks.ScheduleTask;
import com.fixedd.AndroidTrimet.tasks.ArrivalsTask.ArrivalsTaskCaller;
import com.fixedd.AndroidTrimet.tasks.ScheduleTask.ScheduleTaskCaller;
import com.fixedd.AndroidTrimet.tasks.TripTask.TripTaskCaller;
import com.fixedd.AndroidTrimet.util.Util;

/**
 * Base client class for talking to the Trimet API. Instantiate a copy of the class then call one of the public methods to query the API. 
 * @author Jeremy Logan
 * @version 1
 *
 */
public class TrimetClient {
	private String mAppId;

	/**
	 * Class constructor
	 * @since 1  
	 * @param appId The application ID assigned to your application by Trimet. This can be procured from <a href="http://developer.trimet.org/registration/">http://developer.trimet.org/registration/</a>
	 */
	public TrimetClient(String appId) {
		mAppId = appId;
	}

	
	
	
	/**
	 * Reports next arrivals at stops identified by location ID.
	 * @since 1
	 * @param caller The ArrivalsTaskCaller that the task should report back to.
	 * @param locationIDs The array of location IDs you want arrival info for.
	 */
	public void fetchArrivals(ArrivalsTaskCaller caller, int... locationIDs) {
		String url = String.format(Constants.URL_BASE_ARRIVALS, mAppId);
		url += "/locIDs/" + Util.arrayIntsToString(locationIDs);
		
		HttpGet getReq = new HttpGet(url); 
		ArrivalsTask task = new ArrivalsTask(caller);
		task.execute(getReq);
	}
	
	
	
	/**
	 * Looks up information on routes.
	 * @since 1
	 * @param caller The SchedulesTaskCaller that the task should report back to.
	 * @param options The options you want to search by.
	 */
	public void fetchRoutes(ScheduleTaskCaller caller, RouteConfigOptions options) {
		String url = String.format(Constants.URL_BASE_ROUTECONFIG, mAppId);
		
		if (options.getRoutes().length > 0)
			url += "/routes/" + Util.arrayIntsToString(options.getRoutes());
		
		if (options.getDirection() != RouteConfigOptions.DIRECTION_NONE) {
			url += "/dir/";
			switch (options.getDirection()) {
				case RouteConfigOptions.DIRECTION_ALL:
					url += "yes";
					break;
				case RouteConfigOptions.DIRECTION_INBOUND:
					url += "1";
					break;
				case RouteConfigOptions.DIRECTION_OUTBOUND:
					url += "0";
					break;
			}
		}
		
		if (options.getStops()) 
			url += "/stops/yes";
		
		if (options.getTP()) 
			url += "/tp/yes";
		
		if (options.getStartSequence() > -1) 
			url += "/startSeq/" + options.getStartSequence();
		
		if (options.getEndSequence() > -1) 
			url += "/endSeq/"   + options.getEndSequence();
		
		System.out.println(url);
		
		HttpGet getReq = new HttpGet(url); 
		ScheduleTask task = new ScheduleTask(caller);
		task.execute(getReq);
	}
	
	
	
	
	
	/**
	 * Retrieves a list of detours currently in effect by route.
	 * @since 1
	 * @param caller The SchedulesTaskCaller that the task should report back to.
	 * @param routes The list of route IDs you want detour info for. If it's empty (or null) then all detours (for all routes) will be requested. 
	 */
	public void findDetours(ScheduleTaskCaller caller, int... routes) {
		String url = String.format(Constants.URL_BASE_DETOURS, mAppId);
		
		// routes are not required... if it's empty we'll just fetch all
		if (routes != null && routes.length > 0)
			url += "/routes/" + Util.arrayIntsToString(routes);
		
		HttpGet getReq = new HttpGet(url); 
		ScheduleTask task = new ScheduleTask(caller);
		task.execute(getReq);
	}
	
	
	
	
	
	/**
	 * Find stops near the specified location.
	 * @since 1
	 * @param caller The ArrivalsTaskCaller that the task should report back to.
	 * @param latitude The latitude in decimal format to center the search on (example: 45.523232d).
	 * @param longitude The longitude in decimal format to center the search on (example: -122.671452d).
	 * @param distanceInMeters The radius in which to search for stops (in meters). If the radius is less than 10 then the default of 400 will be used.
	 */
	public void findNearbyStops(ArrivalsTaskCaller caller, double latitude, double longitude, int distanceInMeters) {
		if (distanceInMeters < 10)
			distanceInMeters = 400;
		
		String url = String.format(Constants.URL_BASE_NEARBY, mAppId);
		url += "/ll/" + Double.toString(longitude) + "," + Double.toString(latitude);
		url += "/meters/" + Integer.toString(distanceInMeters);
		
		HttpGet getReq = new HttpGet(url); 
		ArrivalsTask task = new ArrivalsTask(caller);
		task.execute(getReq);
	}
	
	/**
	 * Find stops near the specified location.
	 * @since 1
	 * @param caller The ArrivalsTaskCaller that the task should report back to.
	 * @param location The location to center the search on.
	 * @param distanceInMeters The radius in which to search for stops (in meters). If the radius is less than 10 then the default of 400 will be used.
	 */
	public void findNearbyStops(ArrivalsTaskCaller caller, Location location, int distanceInMeters) {
		findNearbyStops(caller, location.getLatitude(), location.getLongitude(), distanceInMeters);
	}
	
	
	
		
	/**
	 * Plan trips between two locations programmatically.
	 * <p><b>WARNING:</b> This is not yet implemented and will throw a RuntimeException!</p>
	 * @since 1
	 * @param caller The TripTaskCaller that the task should report back to. 
	 * @param options The options you want to plan by.
	 */
	public void planTrip(TripTaskCaller caller, TripPlannerOptions options) {
		throw new RuntimeException("This method is not yet implemented.");
		
//		String url = String.format(Constants.URL_BASE_TRIPPLANNER, mAppId);
//		
//		if (options.getFromPlace()       != null) url += "/fromPlace/"       + options.getFromPlace()      ;
//		if (options.getFromCoord()       != null) url += "/fromCoord/"       + options.getFromCoord()      ;
//		if (options.getToPlace()         != null) url += "/toPlace/"         + options.getToPlace()        ;
//		if (options.getToCoord()         != null) url += "/toCoord/"         + options.getToCoord()        ;
//		if (options.getDate()            != null) url += "/Date/"            + options.getDate()           ;
//		if (options.getTime()            != null) url += "/Time/"            + options.getTime()           ;
//		if (options.getArriveDepart()    != null) url += "/Arr/"             + options.getArriveDepart()   ;
//		if (options.getMaxWalk()         != null) url += "/Walk/"            + options.getMaxWalk()        ;
//		if (options.getMode()            != null) url += "/Mode/"            + options.getMode()           ;
//		if (options.getMaxIntineraries() != null) url += "/MaxIntineraries/" + options.getMaxIntineraries();
//		
//		HttpGet getReq = new HttpGet(url); 
//		TripTask task = new TripTask(caller);
//		task.execute(getReq);
	}
}
