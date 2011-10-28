package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>
 * This class holds information on a returned result set. This is basically
 * the wrapper for all of the other information returned by a RouteConfig or
 * Detour lookup.
 */
public class ResultSet implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected String			mErrorMessage;
	protected List<RouteType>	mRoutes;
	protected List<DetourType>	mDetours;

	public ResultSet() {}

	/**
	 * Gets description of problem if there was an error processing your request.
	 */
	public String getErrorMessage() {
		return mErrorMessage;
	}

	/**
	 * Sets error message's description.
	 */
	public void setErrorMessage(String value) {
		mErrorMessage = value;
	}

	/**
	 * Gets the value of the route property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the RouteType list. This is why there is not a
	 * <CODE>set</CODE> method for the routes property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getRoutes().add(newItem);
	 * </pre>
	 */
	public List<RouteType> getRoutes() {
		if (mRoutes == null) {
			mRoutes = new ArrayList<RouteType>();
		}
		return mRoutes;
	}

	/**
	 * Gets the value of the detour property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the Detour list. This is why there is not a
	 * <CODE>set</CODE> method for the detours property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getDetours().add(newItem);
	 * </pre>
	 */
	public List<DetourType> getDetours() {
		if (mDetours == null) {
			mDetours = new ArrayList<DetourType>();
		}
		return mDetours;
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
		if (mErrorMessage == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mErrorMessage);
		}

		if (mRoutes == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeTypedList(mRoutes);
		}

		if (mDetours == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeTypedList(mDetours);
		}
	}

	public static final Parcelable.Creator<ResultSet> CREATOR = new Parcelable.Creator<ResultSet>() {
		public ResultSet createFromParcel(Parcel in) {
			return new ResultSet(in);
		}

		public ResultSet[] newArray(int size) {
			return new ResultSet[size];
		}
	};

	private ResultSet(Parcel dest) {
		if (dest.readInt() == 1)
			mErrorMessage = dest.readString();
		if (dest.readInt() == 1)
			dest.readTypedList(mRoutes, RouteType.CREATOR);
		if (dest.readInt() == 1)
			dest.readTypedList(mDetours, DetourType.CREATOR);
	}
}
