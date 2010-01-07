package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>This child of the blockPosition will occur for every trip the vehicle 
 * must traverse to arrive at the stop requested.
 */
public class TripType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected int		mProgress	= -2147483648;
	protected int		mDestDist	= -2147483648;
	protected int		mRoute		= -2147483648;
	protected int		mDir		= -2147483648;
	protected int		mTripNum	= -2147483648;
	protected int		mPattern	= -2147483648;
	protected String	mDesc;

	public TripType() {}

	/**
	 * Gets the number of feet the vehicle has traversed along this trip's 
	 * pattern.
	 * @return feet or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getProgress() {
		return mProgress;
	}

	/**
	 * Sets the number of feet the vehicle has traversed along this trip's 
	 * pattern.
	 */
	public void setProgress(int progress) {
		mProgress = progress;
	}

	/**
	 * Gets the number of feet along this trip the vehicle must traverse to 
	 * arrive at the stop requested. If the vehicle must traverse the entire 
	 * trip this number will always be the entire length of the trip.
	 * @return length or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getDestinationDistance() {
		return mDestDist;
	}

	/**
	 * Sets the number of feet along this trip the vehicle must traverse to 
	 * arrive at the stop requested.
	 */
	public void setDestinationDistance(int dist) {
		mDestDist = dist;
	}

	/**
	 * Gets the route number for this trip.
	 * @return route number or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getRouteNumber() {
		return mRoute;
	}

	/**
	 * Sets the route number for this trip.
	 */
	public void setRouteNumber(int route) {
		mRoute = route;
	}

	/**
	 * Gets the direction of the route of this trip.
	 * @return the direction of travel. Either <b>1</b> for inbound, <b>0</b> for outbound, or <b>-2147483648</b> if it wasn't set.
	 */
	public int getDirection() {
		return mDir;
	}

	/**
	 * Sets the direction of the route of this trip.
	 * @param direction Either <b>1</b> for inbound, <b>0</b> for outbound.
	 */
	public void setDirection(int direction) {
		mDir = direction;
	}

	/**
	 * Gets the trip number of this trip.
	 * @return trip number or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getTripNum() {
		return mTripNum;
	}

	/**
	 * Sets the trip number of this trip.
	 */
	public void setTripNum(int value) {
		mTripNum = value;
	}

	/**
	 * Gets the pattern number for the trip.
	 * @return pattern number or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getPattern() {
		return mPattern;
	}

	/**
	 * Sets the pattern number for the trip.
	 */
	public void setPattern(int pattern) {
		mPattern = pattern;
	}

	/**
	 * Gets the route's direction description of the trip.    
	 */
	public String getDesc() {
		return mDesc;
	}

	/**
	 * Sets the route's direction description of the trip.    
	 */
	public void setDesc(String value) {
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
		dest.writeInt(mProgress);
		dest.writeInt(mDestDist);
		dest.writeInt(mRoute);
		dest.writeInt(mDir);
		dest.writeInt(mTripNum);
		dest.writeInt(mPattern);
		if (mDesc == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mDesc);
		}
	}

	public static final Parcelable.Creator<TripType> CREATOR = new Parcelable.Creator<TripType>() {
		public TripType createFromParcel(Parcel in) {
			return new TripType(in);
		}

		public TripType[] newArray(int size) {
			return new TripType[size];
		}
	};

	private TripType(Parcel dest) {
		mProgress = dest.readInt();
		mDestDist = dest.readInt();
		mRoute    = dest.readInt();
		mDir      = dest.readInt();
		mTripNum  = dest.readInt();
		mPattern  = dest.readInt();
		if (dest.readInt() == 1)
			mDesc = dest.readString();
	}
}
