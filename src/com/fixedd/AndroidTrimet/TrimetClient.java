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
		this.mAppId = appId;
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
		
		if (options.getRoutes()        != null) url += "/routes/"   + options.getRoutes()       ;
		if (options.getDirection()     != null) url += "/dir/"      + options.getDirection()    ;
		if (options.getStops()         != null) url += "/stops/"    + options.getStops()        ;
		if (options.getTP()            != null) url += "/tp/"       + options.getTP()           ;
		if (options.getStartSequence() != null) url += "/startSeq/" + options.getStartSequence();
		if (options.getEndSequence()   != null) url += "/endSeq/"   + options.getEndSequence()  ;
		
		HttpGet getReq = new HttpGet(url); 
		ScheduleTask task = new ScheduleTask(caller);
		task.execute(getReq);
	}
	
	
	
	
	
	/**
	 * Retrieves a list of detours currently in effect by route.
	 * @since 1
	 * @param caller The SchedulesTaskCaller that the task should report back to.
	 * @param routes The list of route IDs you want detour info for. If it's empty then all detours (for all routes) will be requested. 
	 */
	public void findDetours(ScheduleTaskCaller caller, int... routes) {
		String url = String.format(Constants.URL_BASE_DETOURS, mAppId);
		
		// routes are not required... if it's empty we'll just fetch all
		if (routes.length > 0)
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
	
	
	
	/**
	 * This allows for the configuration of a Route request. All fields are optional.
	 * @author Jeremy Logan
	 * @since 1
	 *
	 */
	public static class RouteConfigOptions {
		private String mRoutes;
		private String mDir;
		private String mStops;
		private String mTP;
		private String mStartSeq;
		private String mEndSeq;
		
		public enum RouteDirection { INBOUND, OUTBOUND, ALL }
		
		public String getRoutes()   { return mRoutes; }
		public String getDirection(){ return mDir;    }
		public String getStops()    { return mStops;  }
		public String getTP()       { return mTP;     }
		public String getStartSequence() { return mStartSeq; }
		public String getEndSequence()   { return mEndSeq;   }

		/**
		 * Set the routes to look up info for.
		 * @param routes An array of route ids to query for.
		 */
		public void setRoutes(int... routes) {
			if (routes.length < 1)
				throw new RuntimeException("routes can not be empty.");
			
			mRoutes = Util.arrayIntsToString(routes);
		}

		/**
		 * Set the direction to look up info for.
		 * @param direction Direction to search.
		 */
		public void setDirection(RouteDirection direction) {
			switch (direction) {
				case INBOUND:
					mDir = "1";
					break;
				case OUTBOUND:
					mDir = "0";
					break;
				case ALL:
					mDir = "yes";
					break;
			}
		}

		/**
		 * Set whether to return stops for the routes.
		 * @param stops Whether to include stops in the listing.
		 */
		public void setStops(boolean stops) {
			if (stops)
				mStops = "true";
		}

		/**
		 * Set whether to return time-point stops for the routes (if this is set to true then setStops() doesn't need to be set).
		 * @param tp Whether to include time point stops in the listing.
		 */
		public void setTimePoint(boolean tp) {
			if (tp)
				mTP = "true";
		}

		/**
		 * Set this if you want to filter out StopIDs before a certain number. 
		 * @param startSeq StopID to filter before.
		 */
		public void setStartSequence(int startSeq) {
			mStartSeq = Integer.toString(startSeq);
		}

		/**
		 * Set this if you want to filter out StopIDs after a certain number. 
		 * @param endSeq StopID to filter after.
		 */
		public void setEndSequence(int endSeq) {
			mEndSeq = Integer.toString(endSeq);
		}		
	}
	
	/**
	 * This allows for the configuration of a Trip Planner request. 
	 * <p>
	 * All fields are optional with the following caveats:
	 * <ul>
	 * <li>Either FromPlace or FromCoord must be set.</li>
	 * <li>Either ToPlace or ToCoord must be set.</li>
	 * <li>DateTime must be set.</li>
	 * </ul>
	 * <p>
	 * Also note that coords (ToCoord, FromCoord) are always given preference over places (ToPlace, FromPlace).
	 * @since 1
	 * @author Jeremy Logan
	 *
	 */
	public static class TripPlannerOptions {
		private String mFromPlace;
		private String mToPlace;
		private String mFromCoord;
		private String mToCoord;
		private String mDate;
		private String mTime;
		private String mArriveDepart;
		private String mMaxWalk;
		private String mMode;
		private String mMaxIntineraries;
		
		public enum TransitMode {
			ALL_MODES, BUS_ONLY, TRAIN_ONLY
		}
		
		public enum ArriveDepart {
			ARRIVE_BY, DEPART_AFTER
		}
		
		public String getFromPlace()       { return mFromPlace;       }
		public String getToPlace()         { return mToPlace;         }
		public String getFromCoord()       { return mFromCoord;       }
		public String getToCoord()         { return mToCoord;         }
		public String getDate()            { return mDate;            }
		public String getTime()            { return mTime;            }
		public String getArriveDepart()    { return mArriveDepart;    }
		public String getMaxWalk()         { return mMaxWalk;         }
		public String getMode()            { return mMode;            }
		public String getMaxIntineraries() { return mMaxIntineraries; }
		
		
		/**
		 * Set the location from which to begin the trip. 
		 * @param fromPlace A textual representation of a location. For example, an address or a landmark (like 'zoo').
		 */
		public void setFromPlace(String fromPlace) { 
			mFromPlace = fromPlace; 
		}
		
		/**
		 * Set the location from which to end the trip.
		 * @param toPlace A textual representation of a location. For example, an address or a landmark (like 'zoo').
		 */
		public void setToPlace(String toPlace) { 
			mToPlace = toPlace; 
		}
		
		/**
		 * Set the location from which to begin the trip.
		 * @param location GPS representation of a location.
		 */
		public void setFromCoord(Location location) { 
			mFromCoord = Double.toString(location.getLongitude()) + "," + Double.toString(location.getLatitude());
		}
		
		/**
		 * Set the location from which to end the trip.
		 * @param location GPS representation of a location.
		 */
		public void setToCoord(Location location) {
			mToCoord = Double.toString(location.getLongitude()) + "," + Double.toString(location.getLatitude());;
		}
		
		/**
		 * Set the date and time to begin or end the trip.
		 * @param year The year to begin/end trip.
		 * @param monthOfYear The month of the year to begin/end trip.
		 * @param dayOfMonth The day of the month to begin/end trip.
		 * @param hourOfDay The hour of the day to begin/end trip (must be in zero-based 24 hour format). 
		 * @param minuteOfHour The minute of the hour to begin/end trip.
		 */
		public void setDateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
			mDate = monthOfYear + "-" + dayOfMonth + "-" + year;
			if (minuteOfHour > 11)
				mTime = hourOfDay + ":" + minuteOfHour + "%20AM";
			else
				mTime = hourOfDay + ":" + minuteOfHour + "%20PM";
		}
		
		/**
		 * Set whether the trips should arrive by selected datetime or depart after selected datetime.
		 * @param arriveDepart whether to arrive by or depart after
		 */
		public void setArriveDepart(ArriveDepart arriveDepart) {
			switch (arriveDepart) {
				case ARRIVE_BY:
					mArriveDepart = "A";
					break;
				case DEPART_AFTER:
					mArriveDepart = "D";
					break;
			}
		}
		
		/**
		 * Set the maximum walking distance. 
		 * @param maxWalk Maximum distance to walk (range 0.01 -to- 0.999).
		 * @throws Exception thrown if the max walk distance is outside the range.
		 */
		public void setMaxWalk(float maxWalk) throws Exception {
			if ((maxWalk < 0.01) || (maxWalk > 0.999))
				throw new Exception("maxWalk out of range.");
			
			mMaxWalk = Float.toString(maxWalk);
		}
		
		/**
		 * Set which transit modes you'd like to restrict the search to.
		 * @param mode Transit mode for search.
		 */
		public void setMode(TransitMode mode) {
			switch (mode) {
				case ALL_MODES:
					mMode = "A";
					break;
				case BUS_ONLY:
					mMode = "B";
					break;
				case TRAIN_ONLY:
					mMode = "T";
					break;
			}
		}
		
		/**
		 * The number of different itineraries to return (maximum is 6).
		 * @param maxIntineraries Max number of itinereries.
		 */
		public void setMaxIntineraries(int maxIntineraries) {
			mMaxIntineraries = Integer.toString(maxIntineraries);
		}
		
		
	}
}
