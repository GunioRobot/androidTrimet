package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>
 * Contains information about a location, usually a stop. This element can
 * occur in two locations in a resultSet document. One to describe the stop
 * requested, and others to describe the location of any layovers.
 */
public class LocationType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected int				mLocid				= -2147483648;
	protected String			mDesc;
	protected String			mDir;
	protected double			mLat				= -2147483648;
	protected double			mLng				= -2147483648;

	public LocationType() {}

	/**
	 * Gets the value of the locid property.
	 * returns The location id (usually a stop id) for the location or -2147483648 if it wasn't set properly.
	 */
	public int getLocationId() {
		return mLocid;
	}

	/**
	 * Sets the location id for this LocationType.
	 * @param locationId The location id for the location.
	 */
	public void setLocationId(int locationId) {
		mLocid = locationId;
	}

	/**
	 * Gets the description for this location.
	 * @return {@link String} with the description of the location. null will be returned if the direction wasn't set properly.
	 */
	public String getDesciption() {
		return mDesc;
	}

	/**
	 * Sets the description for this location.
	 * @param description A {@link String} indicating the description for the location.
	 */
	public void setDescription(String description) {
		mDesc = description;
	}

	/**
	 * Gets the direction for the stop.
	 * @return A {@link String} indicating the direction the location is headed. null will be returned if the direction wasn't set properly.
	 */
	public String getDirection() {
		return mDir;
	}

	/**
	 * Sets the direction for the stop
	 * @param direction A {@link String} indicating the direction the location is headed.
	 */
	public void setDirection(String direction) {
		mDir = direction;
	}

	/**
	 * Gets the value of the latitude for the location.
	 * @return the latitude for the location or -2147483648 if it wasn't set correctly.
	 */
	public double getLatitude() {
		return mLat;
	}

	/**
	 * Sets the latitude for the location.
	 * @param latitude The latitude for the location.
	 */
	public void setLatitude(double latitude) {
		mLat = latitude;
	}

	/**
	 * Gets the value of the longitude for the location.
	 * @return the longitude for the location or -2147483648 if it wasn't set correctly.
	 */
	public double getLongitude() {
		return mLng;
	}

	/**
	 * Sets the longitude for the location.
	 * @param longitude The longitude for the location.
	 */
	public void setLongitude(double longitude) {
		mLng = longitude;
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
		dest.writeInt(mLocid);
		if (mDesc == null) {
			dest.writeInt(0);
		} else {
			dest.writeInt(1);
			dest.writeString(mDesc);
		}
		if (mDir == null) {
			dest.writeInt(0);
		} else {
			dest.writeInt(1);
			dest.writeString(mDir);
		}

		dest.writeDouble(mLat);
		dest.writeDouble(mLng);
	}

	public static final Parcelable.Creator<LocationType> CREATOR = new Parcelable.Creator<LocationType>() {
		public LocationType createFromParcel(Parcel in) {
			return new LocationType(in);
		}

		public LocationType[] newArray(int size) {
			return new LocationType[size];
		}
	};

	private LocationType(Parcel dest) {
		mLocid = dest.readInt();
		if (dest.readInt() == 1)
			mDesc  = dest.readString();
		if (dest.readInt() == 1)
			mDir   = dest.readString();
		mLat   = dest.readDouble();
		mLng   = dest.readDouble();
	}
}
