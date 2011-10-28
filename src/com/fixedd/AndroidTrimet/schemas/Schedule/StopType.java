package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Holds info on stops in the direction requested.
 */
public class StopType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected String	mDesc;
	protected int		mLocId	= -2147483648;
	protected double	mLat	= -2147483648d;
	protected double	mLng	= -2147483648d;
	protected int		mSeq	= -2147483648;
	protected boolean	mTp		= false;

	public StopType() {}

	/**
	 * Gets the description of the stop.
	 */
	public String getDescription() {
		return mDesc;
	}

	/**
	 * Sets the description of the stop.
	 */
	public void setDescription(String description) {
		mDesc = description;
	}

	/**
	 * Gets the stop's locationID.
	 * @return locationID or <b>-2147483648</b> if it was not set properly.
	 */
	public int getLocationId() {
		return mLocId;
	}

	/**
	 * Sets the stop's locationID.
	 */
	public void setLocationId(int locationId) {
		mLocId = locationId;
	}

	/**
	 * Gets the stop's latitude.
	 * @return latitude or <b>-2147483648</b> if it was not set properly.
	 */
	public double getLatitude() {
		return mLat;
	}

	/**
	 * Sets the stop's latitude.
	 */
	public void setLatitude(double lat) {
		mLat = lat;
	}

	/**
	 * Gets the stop's longitude.
	 * @return longitude or <b>-2147483648</b> if it was not set properly.
	 */
	public double getLongitude() {
		return mLng;
	}

	/**
	 * Sets the stop's longitude.
	 */
	public void setLongitude(double lng) {
		mLng = lng;
	}

	/**
	 * Gets the stop's sequence number for the route's direction.
	 * @return sequence number or <b>-2147483648</b> if it was not set properly.
	 */
	public int getSequence() {
		return mSeq;
	}

	/**
	 * Sets stop's sequence number for the route's direction.
	 */
	public void setSequence(int seq) {
		mSeq = seq;
	}

	/**
	 * Indicates if the stop is considered a time point for the route's direction.
	 */
	public boolean isTp() {
		return mTp;
	}

	/**
	 * Sets whether the stop is considered a time point for the route's direction.
	 */
	public void setTp(boolean value) {
		mTp = value;
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
		if (mDesc == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mDesc );
		}
		dest.writeInt   (mLocId);
		dest.writeDouble(mLat  );
		dest.writeDouble(mLng  );
		dest.writeInt   (mSeq  );
		dest.writeString(Boolean.toString(mTp));
	}

	public static final Parcelable.Creator<StopType> CREATOR = new Parcelable.Creator<StopType>() {
		public StopType createFromParcel(Parcel in) {
			return new StopType(in);
		}

		public StopType[] newArray(int size) {
			return new StopType[size];
		}
	};

	private StopType(Parcel dest) {
		if (dest.readInt() == 1)
			mDesc  = dest.readString();
		mLocId = dest.readInt   ();
		mLat   = dest.readDouble();
		mLng   = dest.readDouble();
		mSeq   = dest.readInt   ();
		mTp    = Boolean.parseBoolean(dest.readString());
	}
}
