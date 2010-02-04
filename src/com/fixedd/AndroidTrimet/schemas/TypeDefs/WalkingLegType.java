package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for WalkingLegType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WalkingLegType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://maps.trimet.org/maps/model/xml}LegType">
 *       &lt;sequence>
 *         &lt;element name="direction" type="{http://maps.trimet.org/maps/model/xml}DirType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class WalkingLegType extends LegType implements Parcelable {

	protected String mDirection = "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public WalkingLegType() {}

	/**
	 * Gets the value of the direction property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDirection() {
		return mDirection;
	}

	/**
	 * Sets the value of the direction property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDirection(String value) {
		mDirection = value;
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
		dest.writeString(mDirection);
		dest.writeString(mId       );
		dest.writeString(mMode     );

		if (mTimeDistance != null) {
			dest.writeInt(1);
			dest.writeParcelable(mTimeDistance, flags);
		} else
			dest.writeInt(0);

		if (mLineURL != null) {
			dest.writeInt(1);
			dest.writeParcelable(mLineURL, flags);
		} else
			dest.writeInt(0);

		if (mFrom != null) {
			dest.writeInt(1);
			dest.writeParcelable(mFrom, flags);
		} else
			dest.writeInt(0);

		if (mTo != null) {
			dest.writeInt(1);
			dest.writeParcelable(mTo, flags);
		} else
			dest.writeInt(0);

		dest.writeString(mOrder.value());
	}

	public static final Parcelable.Creator<WalkingLegType> CREATOR = new Parcelable.Creator<WalkingLegType>() {
		public WalkingLegType createFromParcel(Parcel in) {
			return new WalkingLegType(in);
		}

		public WalkingLegType[] newArray(int size) {
			return new WalkingLegType[size];
		}
	};

	private WalkingLegType(Parcel dest) {
		mDirection = dest.readString();
		mId        = dest.readString();
		mMode      = dest.readString();
		if (dest.readInt() == 1) mTimeDistance = (TimeDistanceType) dest.readParcelable(null);
		if (dest.readInt() == 1) mLineURL      = (GeoURLType      ) dest.readParcelable(null);
		if (dest.readInt() == 1) mFrom         = (PointType       ) dest.readParcelable(null);
		if (dest.readInt() == 1) mTo           = (PointType       ) dest.readParcelable(null);
		mOrder = OrderType.fromValue(dest.readString());
	}
}
