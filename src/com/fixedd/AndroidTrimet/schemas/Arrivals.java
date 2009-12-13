package com.fixedd.AndroidTrimet.schemas;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Arrivals schema.
 * Please see http://developer.trimet.org/schema/arrivals.xsd
 * @author Jeremy Logan
 *
 */
public class Arrivals {
	private String                mErrorMessage = null;
	private List<LocationType>    mLocation     = new ArrayList<LocationType>();;
	private List<ArrivalType>     mArrival      = new ArrayList<ArrivalType>();
	private List<RouteStatusType> mRouteStatus  = new ArrayList<RouteStatusType>();
	private long                  mQueryTime    = 0l;
	private long                  mSystemTime   = System.currentTimeMillis();
	
	/**
	 * Class constructor.
	 */
	public Arrivals() {
		// TODO: import all the resultSet data
		mSystemTime = System.currentTimeMillis();
	}
	
	/**
	 * Get the difference between the local system's time and the server's time.
	 * @return The difference between the local system's time and the server's time.
	 */
	public long getTimeDelta() { return mSystemTime - mQueryTime; }
	/**
	 * Get any error messages returned by the server.
	 * @return error message
	 */
	public String getErrorMessage() { return mErrorMessage; }
	/**
	 * Get all the locations
	 * @return list of locations
	 */
	public List<LocationType> getLocations() { return mLocation; }
	/**
	 * Get all the arrivals
	 * @return list of arrivals
	 */
	public List<ArrivalType> getArrivals() { return mArrival; }
	/**
	 * Get all the route statuses
	 * @return the route statuses
	 */
	public List<RouteStatusType> getRouteStatuses() { return mRouteStatus; }
	/**
	 * Get the time the query took place (according to the server).
	 * @return time in milliseconds since epoch.
	 */
	public long getQueryTime() { return mQueryTime; }
	
	
	
	/**
	 * This class encapsulates the locationType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class LocationType {
		private int    mLocid;
		private String mDesc;
		private String mDir;
		private double mLat;
		private double mLng;
		
		/**
		 * Class constructor
		 */
		public LocationType() {
			// TODO: import all the data
		}

		/**
		 * Get the location id
		 * @return the location id
		 */
		public int    getLocid() { return mLocid; }
		/**
		 * Get the location description
		 * @return the description
		 */
		public String getDesc()  { return mDesc;  }
		/**
		 * Get the location's direction (inbound, outbound)
		 * @return the direction
		 */
		public String getDir()   { return mDir;   }
		/**
		 * Get the location's latitude.
		 * @return the latitude
		 */
		public double getLat()   { return mLat;   }
		/**
		 * Get the location's longitude
		 * @return the longitude
		 */
		public double getLng()   { return mLng;   }
	}
	
	/**
	 * This class encapsulates the arrivalType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class ArrivalType {
		private List<BlockPositionType> mBlockPosition;
		private int     mRoute;
		private int     mLocid;
		private int     mDir;
		private String  mShortSign;
		private String  mFullSign;
		private long    mEstimated;
		private long    mScheduled;
		private int     mBlock;
		private String  mPiece;
		private boolean mDeparted;
		private boolean mDetour;
		private String  mStatus;
		
		/**
		 * Class constructor
		 */
		public ArrivalType() {
			// TODO: import all the data
		}
		
		/**
		 * Get the last known position of the arrival along its block.
		 * @return the last know position of the arrival
		 */
		public List<BlockPositionType> getBlockPosition() { return mBlockPosition; }
		/**
		 * Get the route number of the arrival.
		 * @return The route number of the arrival.
		 */
		public int getRoute() { return mRoute; }
		/**
		 * Get the locID of the arrival.
		 * @return the locID of the arrival.
		 */
		public int getLocid() { return mLocid; }
		/**
		 * Get the direction of the route for this arrival.
		 * @return The direction of the route for this arrival.
		 */
		public int getDir() { return mDir; }
		/**
		 * Get the short version of text from the overhead sign of the vehicle when it arrives at the stop.
		 * @return The short version of text from the overhead sign of the vehicle when it arrives at the stop.
		 */
		public String getShortSign() { return mShortSign; }
		/**
		 * Get the full text of the overhead sign of the vehicle when it arrives at the stop.
		 * @return The full text of the overhead sign of the vehicle when it arrives at the stop.
		 */
		public String getFullSign() { return mFullSign; }
		/**
		 * Get the estimated time for this arrival.
		 * @return The estimated time for this arrival in milliseconds since the epoch. If this value is not present the arrival could not be estimated. Check scheduled time instead.
		 */
		public long getEstimated() { return mEstimated; }
		/**
		 * Get the scheduled stop time (or interpolated scheduled stop time when the stop is not a time point) of the arrival.
		 * @return The scheduled stop time of the arrival in milliseconds since the epoch.
		 */
		public long getScheduled() { return mScheduled; }
		/**
		 * Get the block of the arrival.
		 * @return The block of the arrival.
		 */
		public int getBlock() { return mBlock; }
		/**
		 * Get the piece of the block for this arrival.
		 * @return The piece of the block for this arrival.
		 */
		public String getPiece() { return mPiece; }
		/**
		 * Determine whether the vehicle has begun the trip which will arrival at the requested stop.
		 * @return Whether the vehicle has begun the trip.
		 */
		public boolean isDeparted() { return mDeparted; }
		/**
		 * Determine whether the arrival may be effected by a detour in effect along the route.
		 * @return Whether the vehicle may be effected by a detour.
		 */
		public boolean isDetour() { return mDetour; }
		/**
		 * Get the status of the arrival.
		 * @return the current status of the arrival.
		 */
		public String getStatus() {
			/*
			 * possible values:
			 * 		estimated = arrival time was estimated with vehicle arrival information
			 * 		scheduled = scheduled arrival time is available only. No real time information available for estimation. Bus's radio may be down or vehicle may not be in service. Arrivals are not estimated when further than an hour away.
			 * 		delayed   = status of service is uncertain.
			 * 		canceled  = scheduled arrival was canceled for the day
			 */
			return mStatus; 
		}
		
		
	}
	
	/**
	 * This class encapsulates the blockPositionType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class BlockPositionType {
		private List<TripType>    mTrip;
		private List<LayoverType> mLayover;
		private long   mAt;
		private double mLat;
		private double mLng;
		private int    mHeading;
		private int    mFeet;
		
		/**
		 * Class constructor
		 */
		public BlockPositionType() {
			// TODO: import all the data
		}

		/**
		 * Get the list of trips.
		 * @return The list of trips.
		 */
		public List<TripType> getTrips() { return mTrip; }
		/**
		 * Get the list of layovers.
		 * @return The list of layovers.
		 */
		public List<LayoverType> getLayovers() { return mLayover; }
		/**
		 * Get the time this position was reported.
		 * @return The time this position was reported in milliseconds since epoch.
		 */
		public long getAt() { return mAt; }
		/**
		 * Get the latitude of the vehicle at the time the position was reported.
		 * @return The latitude of the vehicle at the time the position was reported.
		 */
		public double getLat() { return mLat; }
		/**
		 * Get the longitude of the vehicle at the time the position was reported.
		 * @return The longitude of the vehicle at the time the position was reported.
		 */
		public double getLng() { return mLng; }
		/**
		 * Get the heading of the vehicle at the time of the position was reported. 
		 * @return The heading of the vehicle at the time of the position was reported.
		 */
		public int getHeading() { return mHeading; }
		/**
		 * Get the number of feet the vehicle is away from the stop at the time the position was reported.
		 * @return The number of feet vehicle is from stop.
		 */
		public int getFeet() { return mFeet; }
	}

	/**
	 * This class encapsulates the layoverType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class LayoverType {
		private LocationType mLocation;
		private long mStart;
		private long mEnd;
		
		/**
		 * Class constructor
		 */
		public LayoverType() {
			// TODO: import all the data
		}

		/**
		 * Get the location of the layover.
		 * @return The location of the layover.
		 */
		public LocationType getLocation() { return mLocation; }
		/**
		 * Get the layover's start time.
		 * @return start time in milliseconds since the epoch.
		 */
		public long getStart() { return mStart; }
		/**
		 * Get the layover's end time.
		 * @return end time in milliseconds since the epoch.
		 */
		public long getEnd() { return mEnd; }
	}
	
	/**
	 * This class encapsulates the tripType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class TripType {
		private int    mProgress;
		private int    mDestDist;
		private int    mRoute;
		private int    mDir;
		private int    mTripNum;
		private int    mPattern;
		private String mDesc;
		
		/**
		 * Class constructor
		 */
		public TripType() {
			// TODO: import all the data
		}

		/**
		 * Get the number of feet the vehicle has traversed along this trip's pattern.
		 * @return The number of feet the vehicle has traversed along this trip's pattern.
		 */
		public int getProgress() { return mProgress; }
		/**
		 * Get the number of feet along this trip the vehicle must traverse to arrive at the stop requested. If the vehicle must traverse the entire trip this number will always be the entire length of the trip.
		 * @return The number of feet along this trip the vehicle must traverse to arrive at the stop requested.
		 */
		public int getDestDist() { return mDestDist; }
		/**
		 * Get the route number for this trip.
		 * @return The route number for this trip.
		 */
		public int getRoute() { return mRoute; }
		/**
		 * Get the direction of the route of this trip.
		 * @return The direction of the route of this trip.
		 */
		public int getDir() { return mDir; }
		/**
		 * Get the trip number of this trip.
		 * @return The trip number of this trip.
		 */
		public int getTripNum() { return mTripNum; }
		/**
		 * Get the pattern number for the trip.
		 * @return The pattern number for the trip.
		 */
		public int getPattern() { return mPattern; }
		/**
		 * Get the route's direction description of the trip.
		 * @return The route's direction description of the trip.
		 */
		public String getDesc() { return mDesc; }
	}
	
	/**
	 * This class encapsulates the routeStatusType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class RouteStatusType {
		private int mRoute;
		private String mStatus;
		
		/**
		 * Class constructor
		 */
		public RouteStatusType() {
			// TODO: import all the data
		}
		
		/**
		 * Get the routeStatus' route number.
		 * @return The route number.
		 */
		public int getRoute() { return mRoute; }
		/**
		 * Get the status of the routeStatus.
		 * @return the ststus.
		 */
		public String getStatus() {
			return mStatus;
			
			/* 
			 * possible values:
			 * 		estimatedOnly = Arrivals for this route are only being reported if they can be estimated within the next hour. This occurs in inclement weather conditions.
			 * 		off           = No arrivals are being reported for this route. This occurs when conditions such as snow and ice cause vehicles along the route to travel off their trip patterns. In such cases predictions are highly inaccurate or impossible.
			 */
		}
		
		
	}
}
