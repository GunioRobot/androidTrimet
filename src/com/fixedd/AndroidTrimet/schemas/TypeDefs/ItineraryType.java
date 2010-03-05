package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for ItineraryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItineraryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time-distance" type="{http://maps.trimet.org/maps/model/xml}TimeDistanceType"/>
 *         &lt;element name="fare" type="{http://maps.trimet.org/maps/model/xml}FareType"/>
 *         &lt;element name="routes" type="{http://maps.trimet.org/maps/model/xml}RouteSummaryType"/>
 *         &lt;element name="leg" type="{http://maps.trimet.org/maps/model/xml}LegType" maxOccurs="unbounded"/>
 *         &lt;element name="geo" type="{http://maps.trimet.org/maps/model/xml}GeoRouteType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="viaRoute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ItineraryType implements Parcelable {
	protected TimeDistanceType		mTimeDistance;
	protected FareType				mFare;
	protected RouteSummaryType		mRoutes;
	protected List<LegType>			mLeg;
	protected List<GeoRouteType>	mGeo;
	protected String				mId			= "";
	protected String				mViaRoute	= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public ItineraryType() {}

	/**
	 * Gets the value of the timeDistance property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link TimeDistanceType }
	 *     
	 */
	public TimeDistanceType getTimeDistance() {
		return mTimeDistance;
	}

	/**
	 * Sets the value of the timeDistance property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link TimeDistanceType }
	 *     
	 */
	public void setTimeDistance(TimeDistanceType value) {
		mTimeDistance = value;
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

	/**
	 * Gets the value of the routes property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link RouteSummaryType }
	 *     
	 */
	public RouteSummaryType getRoutes() {
		return mRoutes;
	}

	/**
	 * Sets the value of the routes property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link RouteSummaryType }
	 *     
	 */
	public void setRoutes(RouteSummaryType value) {
		mRoutes = value;
	}

	/**
	 * Gets the value of the leg property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the leg property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getLeg().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link LegType }
	 * 
	 * 
	 */
	public List<LegType> getLeg() {
		if (mLeg == null) {
			mLeg = new ArrayList<LegType>();
		}
		return mLeg;
	}

	/**
	 * Gets the value of the geo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the geo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getGeo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link GeoRouteType }
	 * 
	 * 
	 */
	public List<GeoRouteType> getGeo() {
		if (mGeo == null) {
			mGeo = new ArrayList<GeoRouteType>();
		}
		return mGeo;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setId(String value) {
		mId = value;
	}

	/**
	 * Gets the value of the viaRoute property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getViaRoute() {
		return mViaRoute;
	}

	/**
	 * Sets the value of the viaRoute property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setViaRoute(String value) {
		mViaRoute = value;
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
		if (mTimeDistance != null) {
			dest.writeInt(1);
			dest.writeParcelable(mTimeDistance, flags);
		} else 
			dest.writeInt(0);

		if (mFare != null) {
			dest.writeInt(1);
			dest.writeParcelable(mFare, flags);
		} else 
			dest.writeInt(0);

		if (mRoutes != null) {
			dest.writeInt(1);
			dest.writeParcelable(mRoutes, flags);
		} else 
			dest.writeInt(0);

		if (mLeg != null && mLeg.size() > 0) {
			// legs can be either TransitLegType or WalkingLegType. separate them into two lists
			ArrayList<WalkingLegType> walkingLegs = new ArrayList<WalkingLegType>();
			ArrayList<TransitLegType> transitLegs = new ArrayList<TransitLegType>();
			for (int i=0; i<mLeg.size(); i++) {
				if (mLeg.get(i) instanceof WalkingLegType)
					walkingLegs.add((WalkingLegType) mLeg.get(i));
				else
					transitLegs.add((TransitLegType) mLeg.get(i));
			}
			// store the walking legs
			if (walkingLegs.size() > 0) {
				dest.writeInt(1);
				dest.writeTypedList(walkingLegs);
			} else
				dest.writeInt(0);
			// store the transit legs
			if (transitLegs.size() > 0) {
				dest.writeInt(1);
				dest.writeTypedList(transitLegs);
			} else
				dest.writeInt(0);
		}

		if (mGeo != null && mGeo.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mGeo);
		} else 
			dest.writeInt(0);

		dest.writeString(mId      );
		dest.writeString(mViaRoute);
	}

	public static final Parcelable.Creator<ItineraryType> CREATOR = new Parcelable.Creator<ItineraryType>() {
		public ItineraryType createFromParcel(Parcel in) {
			return new ItineraryType(in);
		}

		public ItineraryType[] newArray(int size) {
			return new ItineraryType[size];
		}
	};

	public ItineraryType(Parcel dest) {
		if (dest.readInt() == 1) mTimeDistance = (TimeDistanceType) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mFare         = (FareType        ) dest.readParcelable(getClass().getClassLoader());
		if (dest.readInt() == 1) mRoutes       = (RouteSummaryType) dest.readParcelable(getClass().getClassLoader());
		
		// mLeg can contain WalkingLegTypes or TransitLegTypes. Pull them out then combine them.
		ArrayList<WalkingLegType> walkingLegs = new ArrayList<WalkingLegType>();
		ArrayList<TransitLegType> transitLegs = new ArrayList<TransitLegType>();
		if (dest.readInt() == 1)
			dest.readTypedList(walkingLegs, WalkingLegType.CREATOR);
		if (dest.readInt() == 1)
			dest.readTypedList(transitLegs, TransitLegType.CREATOR);
		mLeg = new ArrayList<LegType>();
		mLeg.addAll(walkingLegs);
		mLeg.addAll(transitLegs);
			
		if (dest.readInt() == 1) {
			mGeo = new ArrayList<GeoRouteType>();
			dest.readTypedList(mGeo, GeoRouteType.CREATOR);
		}
		mId       = dest.readString();
		mViaRoute = dest.readString();
	}
}
