package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/** 
 * <p>
 * This class will occur as a child of the blockPosition for every layover the 
 * vehicle has between its position and the requested arrival.
 */
public class LayoverType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected LocationType	mLocation;
	protected long			mStart	= -9223372036854775808l;
	protected long			mEnd	= -9223372036854775808l;

	public LayoverType() {}

	/**
	 * Gets the value of the location property.
	 * @return Returns a {@link LocationType } or null (it it wasn't set properly).
	 */
	public LocationType getLocation() {
		return mLocation;
	}

	/**
	 * Sets the value of the location property.
	 * @param location Allowed object is {@link LocationType }
	 */
	public void setLocation(LocationType location) {
		mLocation = location;
	}

	/**
	 * Gets the time that the layover starts. 
	 * @return Returns the time that the layover starts (in milliseconds since epoch) or -9223372036854775808 if the time was not set properly.
	 */
	public long getStartTime() {
		return mStart;
	}

	/**
	 * Sets the start time for the layover.
	 * @param time The time (in milliseconds since epoch) that the layover starts. 
	 */
	public void setStartTime(long time) {
		mStart = time;
	}

	/**
	 * Gets the time that the layover ends. 
	 * @return Returns the time that the layover ends (in milliseconds since epoch) or -9223372036854775808 if the time was not set properly.
	 */
	public long getEndTime() {
		return mEnd;
	}

	/**
	 * Sets the end time for the layover.
	 * @param time The time (in milliseconds since epoch) that the layover ends.
	 */
	public void setEndTime(long time) {
		mEnd = time;
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
		if (mLocation == null) {
			dest.writeInt(0);
		} else {
			dest.writeInt(1);
			dest.writeParcelable(mLocation, flags);
		}

		dest.writeLong(mStart);
		dest.writeLong(mEnd  );
	}

	public static final Parcelable.Creator<LayoverType> CREATOR = new Parcelable.Creator<LayoverType>() {
		public LayoverType createFromParcel(Parcel in) {
			return new LayoverType(in);
		}

		public LayoverType[] newArray(int size) {
			return new LayoverType[size];
		}
	};

	private LayoverType(Parcel dest) {
		if (dest.readInt() == 1)
			mLocation = (LocationType) dest.readParcelable(getClass().getClassLoader());

		mStart = dest.readLong();
		mEnd   = dest.readLong();
	}
}
