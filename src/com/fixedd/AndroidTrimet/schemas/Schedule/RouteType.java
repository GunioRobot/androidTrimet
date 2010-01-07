package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Contains information the configuration of a route
 */
public class RouteType implements Parcelable {
	/**
	 * A "Bus" route type.
	 * @see #setType(int)
	 * @see #getType()
	 */
	public final static int TYPE_BUS   = 0;
	/**
	 * A "fixed guide way" (either rail or aerial tram) route.
	 * @see #setType(int)
	 * @see #getType()
	 */
	public final static int TYPE_FIXED = 1;


	protected List<RouteDirectionType>	mDirections;
	protected int						mRoute	= -2147483648;
	protected String					mDesc;
	protected boolean					mDetour	= false;
	protected int						mType   = 0;


	public RouteType() {} 

	/**
	 * Gets the directions list.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the direction list.
	 * This is why there is not a <CODE>set</CODE> method for the dir property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getDirections().add(newItem);
	 * </pre>
	 */
	public List<RouteDirectionType> getDirections() {
		if (mDirections == null) {
			mDirections = new ArrayList<RouteDirectionType>();
		}
		return mDirections;
	}

	/**
	 * Gets the route number.
	 * @return the route number or <b>-2147483648</b> if it wasn't set properly.
	 */
	public int getRouteNumber() {
		return mRoute;
	}

	/**
	 * Sets the route number.
	 */
	public void setRouteNumber(int value) {
		mRoute = value;
	}

	/**
	 * Gets the route's description.    
	 */
	public String getDescription() {
		return mDesc;
	}

	/**
	 * Sets the route's description.    
	 */
	public void setDescription(String description) {
		mDesc = description;
	}

	/**
	 * Indicates if this route has a detour in effect.
	 */
	public boolean isDetour() {
		return mDetour;
	}

	/**
	 * Sets whether the route has a detour in effect.    
	 */
	public void setDetour(boolean value) {
		mDetour = value;
	}

	/**
	 * Gets the type of the route.
	 * @return the type of the route. Either {@link #TYPE_BUS} or {@link #TYPE_FIXED}.
	 */
	public int getType() {
		return mType;
	}

	/**
	 * Set the type of the route.
	 * @param type Either {@link #TYPE_BUS} or {@link #TYPE_FIXED}.
	 */
	public void setType(int type) {
		mType = type;
	}

	/**
	 * Set the type of the route.
	 * @param type Either "B" (for bus) or "R" (for fixed guide way).
	 */
	public void setType(String type) {
		if (type.equalsIgnoreCase("B"))
			mType = TYPE_BUS;
		else if (type.equalsIgnoreCase("R"))
			mType = TYPE_FIXED;
		else
			throw new RuntimeException("Type must be \"B\" or \"R\".");
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
		if (mDirections == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeTypedList(mDirections  );
		}

		dest.writeInt      (mRoute);
		dest.writeString   (mDesc );
		dest.writeString   (Boolean.toString(mDetour));
		dest.writeInt      (mType );
	}

	public static final Parcelable.Creator<RouteType> CREATOR = new Parcelable.Creator<RouteType>() {
		public RouteType createFromParcel(Parcel in) {
			return new RouteType(in);
		}

		public RouteType[] newArray(int size) {
			return new RouteType[size];
		}
	};

	private RouteType(Parcel dest) {
		if (dest.readInt() == 1) 
			dest.readTypedList(mDirections, RouteDirectionType.CREATOR);

		mRoute  = dest.readInt();
		mDesc   = dest.readString();
		mDetour = Boolean.parseBoolean(dest.readString());
		mType   = dest.readInt();
	}
}
