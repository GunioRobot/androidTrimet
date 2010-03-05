package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for TransitLegType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitLegType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://maps.trimet.org/maps/model/xml}LegType">
 *       &lt;sequence>
 *         &lt;element name="route" type="{http://maps.trimet.org/maps/model/xml}RouteType"/>
 *         &lt;element name="fare" type="{http://maps.trimet.org/maps/model/xml}FareType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class TransitLegType extends LegType implements Parcelable {
	protected RouteType	mRoute;
	protected FareType	mFare;

	/**
	 * Create a new, empty copy of this object.
	 */
	public TransitLegType() {}

	/**
	 * Gets the value of the route property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link RouteType }
	 *     
	 */
	public RouteType getRoute() {
		return mRoute;
	}

	/**
	 * Sets the value of the route property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link RouteType }
	 *     
	 */
	public void setRoute(RouteType value) {
		mRoute = value;
	}

	/**
	 * Gets the value of the fare property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link FareType }
	 *     
	 */
	public FareType getFare() {
		return mFare;
	}

	/**
	 * Sets the value of the fare property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link FareType }
	 *     
	 */
	public void setFare(FareType value) {
		mFare = value;
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
		if (mRoute != null) {
			dest.writeInt(1);
			dest.writeParcelable(mRoute, flags);
		} else
			dest.writeInt(0);

		if (mFare != null) {
			dest.writeInt(1);
			dest.writeParcelable(mFare, flags);
		} else
			dest.writeInt(0);

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
		dest.writeString(mId           );
		dest.writeString(mMode         );
	}

	public static final Parcelable.Creator<TransitLegType> CREATOR = new Parcelable.Creator<TransitLegType>() {
		public TransitLegType createFromParcel(Parcel in) {
			return new TransitLegType(in);
		}

		public TransitLegType[] newArray(int size) {
			return new TransitLegType[size];
		}
	};

	private TransitLegType(Parcel dest) {
		if (dest.readInt() == 1) mRoute        = (RouteType       ) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mFare         = (FareType        ) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mTimeDistance = (TimeDistanceType) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mLineURL      = (GeoURLType      ) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mFrom         = (PointType       ) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mTo           = (PointType       ) dest.readParcelable(getClass().getClassLoader());
		mOrder = OrderType.fromValue(dest.readString());
		mId    = dest.readString();
		mMode  = dest.readString();
	}
}
