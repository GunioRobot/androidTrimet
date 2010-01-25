package com.fixedd.AndroidTrimet;

import android.location.Location;

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
 * Also note that coords (ToCoord, FromCoord) are always given preference over
 * places (ToPlace, FromPlace).
 * <p>
 * For a complete explanation of these options, please see <a 
 * href="http://developer.trimet.org/ws_docs/tripplanner_ws.shtml">http://developer.trimet.org/ws_docs/tripplanner_ws.shtml</a>
 * 
 * @since 1
 * @author Jeremy Logan
 * 
 */
public class TripPlannerOptions {
	/**
	 * All (both) modes.
	 * 
	 * @see #setMode(String)
	 * @see #getMode()
	 */
	public static final String	MODE_ALL			= "A";
	/**
	 * Bus-only modes.
	 * 
	 * @see #setMode(String)
	 * @see #getMode()
	 */
	public static final String	MODE_BUS			= "B";
	/**
	 * Train-only mode.
	 * 
	 * @see #setMode(String)
	 * @see #getMode()
	 */
	public static final String	MODE_TRAIN			= "T";
	/**
	 * Arrive by the time supplied.
	 * 
	 * @see #setArriveDepart(String)
	 * @see #getArriveDepart()
	 */
	public static final String	WHEN_ARRIVE_BY		= "A";
	/**
	 * Depart after the time supplied.
	 * 
	 * @see #setArriveDepart(String)
	 * @see #getArriveDepart()
	 */
	public static final String	WHEN_DEPART_AFTER	= "D";

	private String				mFromPlace			= null;
	private String				mToPlace			= null;
	private Location			mFromCoord			= null;
	private Location			mToCoord			= null;
	private String				mDate				= null;
	private String				mTime				= null;
	private String				mArriveDepart		= null;
	private String				mMaxWalk			= null;
	private String				mMode				= null;
	private int					mMaxIntineraries	= -1;

	/**
	 * Gets the textual representation for the origin to search for.
	 * @return the origin or null, if not set.
	 */
	public String getFromPlace() {
		return mFromPlace;
	}

	/**
	 * Gets the textual representation for the destination to search for.
	 * @return the destination or null, if not set.
	 */
	public String getToPlace() {
		return mToPlace;
	}

	/**
	 * Gets the GPS coordinate pair for the origin to search for.
	 * @return a {@link Location} object that wraps the coordinate pair or 
	 *         null, if not set.
	 */
	public Location getFromCoord() {
		return mFromCoord;
	}

	/**
	 * Gets the GPS coordinate pair for the destination to search for.
	 * @return a {@link Location} object that wraps the coordinate pair or 
	 *         null, if not set.
	 */
	public Location getToCoord() {
		return mToCoord;
	}

	/**
	 * Gets the date formatted for the request (e.g., "7-6-2010" for the 6th 
	 * of July in 2010).
	 * @return the date for the request or null, if not set.
	 */
	public String getDate() {
		return mDate;
	}

	/**
	 * Gets the time formatted for the request (e.g., "8:20 PM").
	 * @return the time for the request or null, if not set.
	 */
	public String getTime() {
		return mTime;
	}

	/**
	 * Gets whether to search for trips arriving by the date/time or departing 
	 * after the date/time.
	 * @return Either {@link #WHEN_ARRIVE_BY} or {@link #WHEN_DEPART_AFTER} or 
	 *         null, if not set.
	 */
	public String getArriveDepart() {
		return mArriveDepart;
	}

	/**
	 * Gets the maximum walking distance to request. 
	 * @return maximum walking distance as a {@link String} or null, if not set.
	 */
	public String getMaxWalk() {
		return mMaxWalk;
	}

	/**
	 * Gets the mode to restrict the requested search to.
	 * @return Either {@link #MODE_ALL}, {@link #MODE_BUS}, or 
	 *         {@link #MODE_TRAIN} or null, if not set.
	 */
	public String getMode() {
		return mMode;
	}

	/**
	 * Gets the maximum number of itineraries to request. 
	 * @return a number between 1 and 6 or -1, if not set.
	 */
	public int getMaxIntineraries() {
		return mMaxIntineraries;
	}

	
	
	/**
	 * Set the location from which to begin the trip.
	 * 
	 * @param fromPlace A textual representation of a location. For example, an
	 *        address or a landmark (like 'zoo').
	 */
	public void setFromPlace(String fromPlace) {
		mFromPlace = fromPlace;
	}

	/**
	 * Set the location from which to end the trip.
	 * 
	 * @param toPlace A textual representation of a location. For example, an
	 *        address or a landmark (like 'zoo').
	 */
	public void setToPlace(String toPlace) {
		mToPlace = toPlace;
	}

	/**
	 * Set the location from which to begin the trip.
	 * 
	 * @param location GPS representation of a {@link Location}.
	 */
	public void setFromCoord(Location location) {
		mFromCoord = location;
	}

	/**
	 * Set the location from which to end the trip.
	 * 
	 * @param location GPS representation of a {@link Location}.
	 */
	public void setToCoord(Location location) {
		mToCoord = location;
	}

	/**
	 * Set the date and time to begin or end the trip.
	 * 
	 * @param year The year to begin/end trip (e.g., 2010).
	 * @param monthOfYear The month of the year to begin/end trip (1-12).
	 * @param dayOfMonth The day of the month to begin/end trip (1-31).
	 * @param hourOfDay The hour of the day to begin/end trip (0-23).
	 * @param minuteOfHour The minute of the hour to begin/end trip (0-59).
	 */
	public void setDateTime(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
		if (year < 2010 || year > 2100)
			throw new RuntimeException("year out of range (2010-2100, inclusive).");
		if (monthOfYear < 1 || monthOfYear > 12)
			throw new RuntimeException("monthOfYear out of range (1-12, inclusive).");
		if (dayOfMonth < 1 || dayOfMonth > 31)
			throw new RuntimeException("dayOfMonth out of range (1-31, inclusive).");
		if (hourOfDay < 0 || hourOfDay > 23)
			throw new RuntimeException("hourOfDay out of range (0-23, inclusive).");
		if (minuteOfHour < 0 || minuteOfHour > 59)
			throw new RuntimeException("minuteOfHour out of range (0-59, inclusive).");
		
		mDate = monthOfYear + "-" + dayOfMonth + "-" + year;
		if (hourOfDay > 11)
			mTime = hourOfDay + ":" + minuteOfHour + " PM";
		else
			mTime = hourOfDay + ":" + minuteOfHour + " AM";
	}

	/**
	 * Set whether the trips should arrive by selected datetime or depart after
	 * selected datetime.
	 * 
	 * @param arriveDepart whether to arrive by or depart after. Must be either
	 *        {@link #WHEN_ARRIVE_BY} or {@link #WHEN_DEPART_AFTER}.
	 */
	public void setArriveDepart(String arriveDepart) {
		if (!arriveDepart.contentEquals(WHEN_ARRIVE_BY) && !arriveDepart.contentEquals(WHEN_DEPART_AFTER))
			throw new RuntimeException("ArriveDepart must be A or D.");
		mArriveDepart = arriveDepart;
	}

	/**
	 * Set the maximum walking distance.
	 * 
	 * @param maxWalk Maximum distance to walk (0.01 to 0.999).
	 * @throws Exception thrown if the max walk distance is outside the range.
	 */
	public void setMaxWalk(float maxWalk) {
		if ((maxWalk < 0.01) || (maxWalk > 0.999))
			throw new RuntimeException("maxWalk out of range (0.01-0.999).");

		mMaxWalk = Float.toString(maxWalk);
	}

	/**
	 * Set which transit modes you'd like to restrict the search to.
	 * 
	 * @param mode Transit mode for search. Must be either {@link #MODE_ALL},
	 *        {@link #MODE_BUS}, or {@link #MODE_TRAIN}.
	 */
	public void setMode(String mode) {
		if (!mode.contentEquals(MODE_ALL) && !mode.contentEquals(MODE_BUS) && !mode.contentEquals(MODE_TRAIN))
			throw new RuntimeException("Mode must be 'A', 'B', or 'T'.");
		mMode = mode;
	}

	/**
	 * The number of different itineraries to return (minimum 1, maximum 6).
	 * 
	 * @param maxIntineraries Max number of itineraries, between 1 and 6 (inclusive).
	 */
	public void setMaxIntineraries(int maxIntineraries) {
		if (maxIntineraries < 1 || maxIntineraries > 6)
			throw new RuntimeException("Itineraries must be between 1 and 6 (inclusive).");
		mMaxIntineraries = maxIntineraries;
	}

}
