package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * <p>Contains information for each route directions.
 */
public class RouteDirectionType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected List<StopType>	mStops;
	protected int				mDir	= -2147483648;
	protected String			mDesc;

	public RouteDirectionType() {}

	/**
	 * Gets the stops list.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the stops list.
	 * This is why there is not a <CODE>set</CODE> method for the stop property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getStops().add(newItem);
	 * </pre>
	 */
	public List<StopType> getStops() {
		if (mStops == null) {
			mStops = new ArrayList<StopType>();
		}
		return mStops;
	}

	/**
	 * Gets the number of the direction.
	 * @return direction: either 1 for inbound or 0 for outbound.
	 */
	public int getDirection() {
		return mDir;
	}

	/**
	 * Sets the number of the direction.
	 * @param direction either 1 for inbound or 0 for outbound.
	 */
	public void setDirection(int direction) {
		if (direction != 0 && direction != 1)
			throw new RuntimeException("The direction must be either 0 or 1.");
		mDir = direction;
	}

	/**
	 * Gets the description for the direction of the route.    
	 */
	public String getDescription() {
		return mDesc;
	}

	/**
	 * Sets the description for the direction of the route.    
	 */
	public void setDescription(String value) {
		mDesc = value;
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
		if (mStops == null || mStops.size() == 0)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeTypedList(mStops);
		}

		dest.writeInt(mDir );

		if (mDesc == null)
			dest.writeInt(0);
		else { 
			dest.writeInt(1);
			dest.writeString(mDesc);
		}
	}

	public static final Parcelable.Creator<RouteDirectionType> CREATOR = new Parcelable.Creator<RouteDirectionType>() {
		public RouteDirectionType createFromParcel(Parcel in) {
			return new RouteDirectionType(in);
		}

		public RouteDirectionType[] newArray(int size) {
			return new RouteDirectionType[size];
		}
	};

	private RouteDirectionType(Parcel dest) {
		if (dest.readInt() == 1)
			dest.readTypedList(mStops, StopType.CREATOR);

		mDir = dest.readInt();

		if (dest.readInt() == 1)
			mDesc = dest.readString();
	}
}
