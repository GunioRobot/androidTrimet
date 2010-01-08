package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>
 * This class occurs to indicate conditions are influencing the reporting of
 * arrivals being reported for a route. This occurs in inclement weather
 * conditions.
 */
public class RouteStatusType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * Arrivals for this route are only being reported if they can be estimated 
	 * within the next hour. This occurs in inclement weather conditions.
	 * @see #setStatus(int)
	 * @see #getStatus()
	 */
	public final static int	STATUS_ESTIMATED_ONLY	= 0;
	/**
	 * No arrivals are being reported for this route. This occurs when 
	 * conditions such as snow and ice cause vehicles along the route to travel 
	 * off their trip patterns. In such cases predictions are highly inaccurate 
	 * or impossible.
	 * @see #setStatus(int)
	 * @see #getStatus()
	 */
	public final static int	STATUS_OFF				= 1;

	protected int			mRoute					= -2147483648;
	protected int			mStatus					= -2147483648;

	public RouteStatusType() {}

	/**
	 * Gets the number of the route or -2147483648 if it wasn't set properly.
	 */
	public int getRouteNumber() {
		return mRoute;
	}

	/**
	 * Sets the route number for the route.
	 * 
	 * @param the id for the route.
	 */
	public void setRouteNumber(int routeId) {
		mRoute = routeId;
	}

	/**
	 * Gets the status of the route.
	 * 
	 * @return The status of the route. Either {@link #STATUS_ESTIMATED_ONLY} 
	 *     or {@link #STATUS_OFF}. It could also be <b>-2147483648</b> if it 
	 *     wasn't set properly.
	 */
	public int getStatus() {
		return mStatus;
	}

	/**
	 * Sets the route's status.
	 * 
	 * @param status {@link String} must be either "estimatedOnly" or "off".
	 */
	public void setStatus(String status) {
		if (status.equalsIgnoreCase("estimatedOnly"))
			mStatus = STATUS_ESTIMATED_ONLY;
		else if (status.equalsIgnoreCase("off"))
			mStatus = STATUS_OFF;
		else
			throw new RuntimeException("Passed in status was invalid.");
	}
	
	/**
	 * Sets the route's status.
	 * 
	 * @param the status of the route. Either {@link #STATUS_ESTIMATED_ONLY} 
	 * or {@link #STATUS_OFF}.
	 */
	public void setStatus(int status) {
		mStatus = status;
	}

	// **********************************************
	// for implementing Parcelable
	// **********************************************

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mRoute);
		dest.writeInt(mStatus);
	}

	public static final Parcelable.Creator<RouteStatusType>	CREATOR	= new Parcelable.Creator<RouteStatusType>() {
		public RouteStatusType createFromParcel(Parcel in) {
			return new RouteStatusType(in);
		}

		public RouteStatusType[] newArray(int size) {
			return new RouteStatusType[size];
		}
	};

	private RouteStatusType(Parcel dest) {
		mRoute  = dest.readInt();
		mStatus = dest.readInt();
	}

}
