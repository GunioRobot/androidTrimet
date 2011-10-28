package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Contains information about a detour that may apply to one or more routes at the time the query was made.
 */
public class DetourType implements Parcelable, Serializable {
	private static final long	serialVersionUID	= 1L;

	protected List<RouteType>	mRoutes;
	protected long				mBegin	= -9223372036854775808l;
	protected long				mEnd	= -9223372036854775808l;
	protected String			mId;
	protected String			mDesc;
	protected String			mPhonetic;

	public DetourType() {}

	/**
	 * Gets the routes list.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the routes list.
	 * This is why there is not a <CODE>set</CODE> method for the route property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getRoutes().add(newItem);
	 * </pre>
	 */
	public List<RouteType> getRoutes() {
		if (mRoutes == null) {
			mRoutes = new ArrayList<RouteType>();
		}
		return mRoutes;
	}

	/**
	 * Gets the time the detour begins. This will always be a time prior to
	 * the time the query was made.
	 *
	 * <p>This field is used internally and may be of little use outside of
	 * TriMet.
	 * @return time in milliseconds since epoch or <b>-9223372036854775808</b>
	 * if it was set improperly.
	 */
	public long getBeginTime() {
		return mBegin;
	}

	/**
	 * Sets the time the detour begins.
	 * @param time milliseconds since epoch.
	 */
	public void setBeginTime(long time) {
		mBegin = time;
	}

	/**
	 * Gets the time the detour will become invalid. Note that this will
	 * always be a time after the time the query was made. Some end times will
	 * be very far in the future and will be removed once the detour is no
	 * longer in effect.
	 *
	 * <p>This field is used internally and may be of little use outside of
	 * TriMet.
	 * @return time in milliseconds since epoch or <b>-9223372036854775808</b>
	 * if it was set improperly.
	 */
	public long getEndTime() {
		return mEnd;
	}

	/**
	 * Sets the time the detour will become invalid.
	 * @param time milliseconds since epoch.
	 */
	public void setEndTime(long time) {
		mEnd = time;
	}

	/**
	 * Gets the unique identifier of the detour.
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the unique identifier of the detour.
	 */
	public void setId(String id) {
		mId = id;
	}

	/**
	 * Gets the plain text description of the detour.
	 */
	public String getDescription() {
		return mDesc;
	}

	/**
	 * Sets the plain text description of the detour.
	 */
	public void setDescription(String description) {
		mDesc = description;
	}

	/**
	 * Gets the phonetic spelling of the route detour.
	 *
	 * <p>This field is used by TriMet's 238-Ride text-to-speech system.
	 */
	public String getPhonetic() {
		return mPhonetic;
	}

	/**
	 * Sets the phonetic spelling of the route detour.
	 */
	public void setPhonetic(String value) {
		mPhonetic = value;
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
		if (mRoutes == null || mRoutes.size() == 0)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeTypedList(mRoutes);
		}

		dest.writeLong  (mBegin   );
		dest.writeLong  (mEnd     );

		if (mId == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mId);
		}

		if (mDesc == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mDesc);
		}

		if (mPhonetic == null)
			dest.writeInt(0);
		else {
			dest.writeInt(1);
			dest.writeString(mPhonetic);
		}
	}

	public static final Parcelable.Creator<DetourType> CREATOR = new Parcelable.Creator<DetourType>() {
		public DetourType createFromParcel(Parcel in) {
			return new DetourType(in);
		}

		public DetourType[] newArray(int size) {
			return new DetourType[size];
		}
	};

	private DetourType(Parcel dest) {
		if (dest.readInt() == 1) dest.readTypedList(mRoutes, RouteType.CREATOR);
		mBegin = dest.readLong  ();
		mEnd   = dest.readLong  ();
		if (dest.readInt() == 1) mId       = dest.readString();
		if (dest.readInt() == 1) mDesc     = dest.readString();
		if (dest.readInt() == 1) mPhonetic = dest.readString();
	}
}
