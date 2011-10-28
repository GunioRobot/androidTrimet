package com.fixedd.AndroidTrimet;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This allows for the configuration of a Route request. All fields are optional.
 * <p>
 * For a complete explanation of these options, please see <a
 * href="http://developer.trimet.org/ws_docs/routeConfig_ws.shtml">http://developer.trimet.org/ws_docs/routeConfig_ws.shtml</a>
 * @author Jeremy Logan
 * @since 1
 *
 */
public class RouteConfigOptions implements Parcelable {
	/**
	 * No directions directions.
	 * @see #setDirection(int)
	 * @see #getDirection()
	 */
	public static final int	DIRECTION_NONE		= -1;
	/**
	 * Inbound direction.
	 * @see #setDirection(int)
	 * @see #getDirection()
	 */
	public static final int	DIRECTION_INBOUND	= 0;
	/**
	 * Outbound direction.
	 * @see #setDirection(int)
	 * @see #getDirection()
	 */
	public static final int	DIRECTION_OUTBOUND	= 1;
	/**
	 * All (both) directions.
	 * @see #setDirection(int)
	 * @see #getDirection()
	 */
	public static final int	DIRECTION_ALL		= 2;


	private int			mRoutes[] 	= {};
	private int			mDir		= DIRECTION_NONE;
	private boolean		mStops		= false;
	private boolean		mTP			= false;
	private int			mStartSeq	= -1;
	private int			mEndSeq		= -1;

	public RouteConfigOptions() {}

	public int[] getRoutes() {
		return mRoutes;
	}
	public int getDirection() {
		return mDir;
	}
	public boolean getStops() {
		return mStops;
	}
	public boolean getTP() {
		return mTP;
	}
	public int getStartSequence() {
		return mStartSeq;
	}
	public int getEndSequence() {
		return mEndSeq;
	}

	/**
	 * Set the routes to look up info for.
	 * @param routes An array of route ids to query for.
	 */
	public void setRoutes(int... routes) {
		if (routes.length < 1)
			throw new RuntimeException("Routes can not be empty.");

		mRoutes = routes;
	}

	/**
	 * Set the direction to look up info for.
	 * @param direction Direction to search. One of:
	 * {@link #DIRECTION_INBOUND}, {@link #DIRECTION_OUTBOUND}, or
	 * {@link #DIRECTION_ALL}.
	 */
	public void setDirection(int direction) {
		if (direction != DIRECTION_INBOUND  &&
			direction != DIRECTION_OUTBOUND &&
			direction != DIRECTION_ALL      &&
			direction != DIRECTION_NONE     ) {
			throw new RuntimeException("Direction must be one of: DIRECTION_INBOUND, DIRECTION_OUTBOUND, or DIRECTION_ALL.");
		} else
			mDir = direction;
	}

	/**
	 * Set whether to return stops for the routes.
	 * @param stops Whether to include stops in the listing.
	 */
	public void setStops(boolean stops) {
		mStops = stops;
	}

	/**
	 * Set whether to return time-point stops for the routes (if this is set to true then setStops() doesn't need to be set).
	 * @param tp Whether to include time point stops in the listing.
	 */
	public void setTimePoint(boolean tp) {
		mTP = tp;
	}

	/**
	 * Set this if you want to filter out StopIDs before a certain number.
	 * @param startSeq StopID to filter before.
	 */
	public void setStartSequence(int startSeq) {
		mStartSeq = startSeq;
	}

	/**
	 * Set this if you want to filter out StopIDs after a certain number.
	 * @param endSeq StopID to filter after.
	 */
	public void setEndSequence(int endSeq) {
		mEndSeq = endSeq;
	}



	// **********************************************
	//  for implementing Parcelable
	// **********************************************


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (mRoutes == null || mRoutes.length == 0)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeInt(mRoutes.length);
			dest.writeIntArray(mRoutes);
		}
		dest.writeInt(mDir);
		dest.writeString(Boolean.toString(mStops));
		dest.writeString(Boolean.toString(mTP));
		dest.writeInt(mStartSeq);
		dest.writeInt(mEndSeq);
	}

	public static final Parcelable.Creator<RouteConfigOptions> CREATOR = new Parcelable.Creator<RouteConfigOptions>() {
		public RouteConfigOptions createFromParcel(Parcel in) {
			return new RouteConfigOptions(in);
		}

		public RouteConfigOptions[] newArray(int size) {
			return new RouteConfigOptions[size];
		}
	};

	private RouteConfigOptions(Parcel dest) {
		if (dest.readInt() == 1) {
			mRoutes = new int[dest.readInt()];
			dest.readIntArray(mRoutes);
		}

		mDir      = dest.readInt();
		mStops    = Boolean.parseBoolean(dest.readString());
		mTP       = Boolean.parseBoolean(dest.readString());
		mStartSeq = dest.readInt();
		mEndSeq   = dest.readInt();
	}
}
