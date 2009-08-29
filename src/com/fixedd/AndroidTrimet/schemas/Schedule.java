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
	public String getmErrorMessage() { return mErrorMessage; }
	/**
	 * Get routes applicable for the route numbers provided.
	 * @return The routes.
	 */
	public List<RouteType> getmRoutes() { return mRoutes; }
	/**
	 * Get detours applicable for the route numbers provided.
	 * @return The detours in effect.
	 */
	public List<DetourType> getmDetours() { return mDetours; }

	
	/**
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
		 * @return the mDirs
		 */
		public List<RouteDirectionType> getDirs() { return mDirs; }
		/**
		 * @return the mRoute
		 */
		public int getRoute() { return mRoute; }
		/**
		 * @return the mDesc
		 */
		public String getDesc() { return mDesc; }
		/**
		 * @return the mDetour
		 */
		public boolean isDetour() { return mDetour; }
		/**
		 * @return the mType
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
		 * @return the mStops
		 */
		public List<StopType> getStops() { return mStops; }
		/**
		 * @return the mDir
		 */
		public int getDir() { return mDir; }
		/**
		 * @return the mDesc
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
		 * @return the mDesc
		 */
		public String getDesc() { return mDesc; }
		/**
		 * @return the mLocid
		 */
		public int getLocid() { return mLocid; }
		/**
		 * @return the mLat
		 */
		public double getLat() { return mLat; }
		/**
		 * @return the mLng
		 */
		public double getLng() { return mLng; }
		/**
		 * @return the mSeq
		 */
		public int getSeq() { return mSeq; }
		/**
		 * @return the mTp
		 */
		public boolean isTp() { return mTp; }
	}
	
	/**
	 * This class encapsulates the detourType data from the schema.
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
		 * @return the mRoutes
		 */
		public List<RouteType> getRoutes() { return mRoutes; }
		/**
		 * @return the mBegin
		 */
		public long getBegin() { return mBegin; }
		/**
		 * @return the mEnd
		 */
		public long getEnd() { return mEnd; }
		/**
		 * @return the mId
		 */
		public String getId() { return mId; }
		/**
		 * @return the mDesc
		 */
		public String getDesc() { return mDesc; }
		/**
		 * @return the mPhonetic
		 */
		public String getPhonetic() { return mPhonetic; }
	}
}
