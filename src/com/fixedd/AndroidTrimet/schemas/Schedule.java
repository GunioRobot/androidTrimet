package com.fixedd.AndroidTrimet.schemas;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Schedule schema. Please see http://developer.trimet.org/schema/schedule.xsd
 * @author Jeremy Logan
 *
 */
public class Schedule {
	private String           mErrorMessage = null;
	private List<RouteType>  mRoutes       = new ArrayList<RouteType>();
	private List<DetourType> mDetours      = new ArrayList<DetourType>();
	
	/**
	 * Class constructor
	 */
	public Schedule() {
		// TODO: import all the data
	}

	/**
	 * Get the error message.
	 * @return The error messge
	 */
	public String getErrorMessage() { return mErrorMessage; }
	/**
	 * Get routes applicable for the route numbers provided.
	 * @return The routes.
	 */
	public List<RouteType> getRoutes() { return mRoutes; }
	/**
	 * Get detours applicable for the route numbers provided.
	 * @return The detours in effect.
	 */
	public List<DetourType> getDetours() { return mDetours; }

	
	/**
	 * Contains information on the configuration of a route.
	 * This class encapsulates the routeType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class RouteType {
		private List<RouteDirectionType> mDirs;
		private int     mRoute;
		private String  mDesc;
		private boolean mDetour;
		private String  mType;
		
		/**
		 * Class constructor
		 */
		public RouteType() {
			// TODO: import all the data
		}

		/**
		 * The route's directions.
		 * @return the route's directions.
		 */
		public List<RouteDirectionType> getDirs() { return mDirs; }
		/**
		 * The route's id.
		 * @return the route's id.
		 */
		public int getRoute() { return mRoute; }
		/**
		 * The route's description.
		 * @return the description of the route.
		 */
		public String getDesc() { return mDesc; }
		/**
		 * Indicates if this route has a detour in effect.
		 * @return whether there's a detour in effect for this route.
		 */
		public boolean isDetour() { return mDetour; }
		/**
		 * The type of the route.
		 * @return the type of the route, either 'B' for bus, or 'R' for fixed guide way (either rail or aerial tram).
		 */
		public String getType() { return mType; }
	}
	
	/**
	 * This class encapsulates the routeDirectionType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class RouteDirectionType {
		private List<StopType> mStops;
		private int    mDir;
		private String mDesc;
		
		/**
		 * Class constructor
		 */
		public RouteDirectionType() {
			// TODO: import all the data
		}
		
		/**
		 * The stops associated with this route's direction.
		 * @return the stops associated with this route's direction.
		 */
		public List<StopType> getStops() { return mStops; }
		/**
		 * A number indicating the direction of the route.
		 * @return the number of the direction, either 1 for inbound or 0 for outbound.
		 */
		public int getDir() { return mDir; }
		/**
		 * Describes the direction of the route.
		 * @return the route's description.
		 */
		public String getDesc() { return mDesc; }
	}
	
	/**
	 * This class encapsulates the stopType data from the schema.
	 * @author Jeremy Logan
	 *
	 */
	public class StopType {
		private String  mDesc;
		private int     mLocid;
		private double  mLat;
		private double  mLng;
		private int     mSeq;
		private boolean mTp;
		
		/**
		 * Class constructor
		 */
		public StopType() {
			// TODO: import all the data
		}

		/**
		 * The description of the stop.
		 * @return the description of the stop.
		 */
		public String getDesc() { return mDesc; }
		/**
		 * The stop's locationID.
		 * @return the stop's locationID.
		 */
		public int getLocid() { return mLocid; }
		/**
		 * The stop's latitude.
		 * @return the stop's latitude.
		 */
		public double getLat() { return mLat; }
		/**
		 * The stop's longitude.
		 * @return the stop's longitude.
		 */
		public double getLng() { return mLng; }
		/**
		 * The stop's sequence number for the route's direction.
		 * @return the stop's sequence number for the route's direction.
		 */
		public int getSeq() { return mSeq; }
		/**
		 * Whether the stop is considered a time point for the route's direction.
		 * @return whether the stop is a time point.
		 */
		public boolean isTp() { return mTp; }
	}
	
	/**
	 * This class encapsulates the detourType data from the schema.
	 * Contains information about a detour that may apply to one or more routes at the time the query was made.
	 * @author Jeremy Logan
	 *
	 */
	public class DetourType {
		private List<RouteType> mRoutes;
		private long   mBegin;
		private long   mEnd;
		private String mId;
		private String mDesc;
		private String mPhonetic;
		
		/**
		 * Class constructor
		 */
		public DetourType() {
			// TODO: import all the data
		}

		/**
		 * The routes affected by the detour.
		 * @return the routes
		 */
		public List<RouteType> getRoutes() { return mRoutes; }
		/**
		 * Time the detour begins. This will always be a time prior to the time the query was made. This field is used internally and may be of little use outside of TriMet.
		 * @return the begin time
		 */
		public long getBegin() { return mBegin; }
		/**
		 * The time the detour will become invalid. Note that this will always be a time after the time the query was made. Some end times will be very far in the future and will be removed once the detour is no longer in effect. This field is used internally and may be of little use outside of TriMet.
		 * @return the end time
		 */
		public long getEnd() { return mEnd; }
		/**
		 * A unique identifier of the detour.
		 * @return the id
		 */
		public String getId() { return mId; }
		/**
		 * A plain text description of the detour.
		 * @return the description
		 */
		public String getDesc() { return mDesc; }
		/**
		 * A phonetic spelling of the route detour. This field is used by TriMet's 238-Ride text-to-speech system.
		 * @return the phonetic spelling
		 */
		public String getPhonetic() { return mPhonetic; }
	}
}
