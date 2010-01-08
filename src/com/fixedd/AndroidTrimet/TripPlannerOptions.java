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

	private String				mFromPlace;
	private String				mToPlace;
	private Location			mFromCoord;
	private Location			mToCoord;
	private String				mDate;
	private String				mTime;
	private String				mArriveDepart;
	private String				mMaxWalk;
	private String				mMode;
	private int					mMaxIntineraries	= -1;

	public String getFromPlace() {
		return mFromPlace;
	}

	public String getToPlace() {
		return mToPlace;
	}

	public Location getFromCoord() {
		return mFromCoord;
	}

	public Location getToCoord() {
		return mToCoord;
	}

	public String getDate() {
		return mDate;
	}

	public String getTime() {
		return mTime;
	}

	public String getArriveDepart() {
		return mArriveDepart;
	}

	public String getMaxWalk() {
		return mMaxWalk;
	}

	public String getMode() {
		return mMode;
	}

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
	 * @param year The year to begin/end trip.
	 * @param monthOfYear The month of the year to begin/end trip.
	 * @param dayOfMonth The day of the month to begin/end trip.
	 * @param hourOfDay The hour of the day to begin/end trip (must be in
	 *        zero-based 24 hour format).
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
	 * @param maxWalk Maximum distance to walk (range 0.01 -to- 0.999).
	 * @throws Exception thrown if the max walk distance is outside the range.
	 */
	public void setMaxWalk(float maxWalk) throws Exception {
		if ((maxWalk < 0.01) || (maxWalk > 0.999))
			throw new RuntimeException("maxWalk out of range.");

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
			throw new RuntimeException("Mode must be A, B, or T.");
		mMode = mode;
	}

	/**
	 * The number of different itineraries to return (minimum 1, maximum 6).
	 * 
	 * @param maxIntineraries Max number of itineraries.
	 */
	public void setMaxIntineraries(int maxIntineraries) {
		if (maxIntineraries < 1 || maxIntineraries > 6)
			throw new RuntimeException(
				"Itineraries must be between 1 and 6 (inclusive).");
		mMaxIntineraries = maxIntineraries;
	}

}
