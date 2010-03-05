package com.fixedd.AndroidTrimet.schemas.Itinerary;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.fixedd.AndroidTrimet.schemas.TypeDefs.PointType;


/**
 * <p>Java class for LocationListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location" type="{http://maps.trimet.org/maps/model/xml}PointType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class LocationListType implements Parcelable {

	protected String			mQuery	= "";
	protected List<PointType>	mLocation;
	protected int				mCount	= -2147483648;

	/**
	 * Create a new, empty copy of this object.
	 */
	public LocationListType() {}

	/**
	 * Gets the value of the query property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getQuery() {
		return mQuery;
	}

	/**
	 * Sets the value of the query property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setQuery(String value) {
		mQuery = value;
	}

	/**
	 * Gets the value of the location property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the location property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getLocation().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PointType }
	 * 
	 * 
	 */
	public List<PointType> getLocation() {
		if (mLocation == null) {
			mLocation = new ArrayList<PointType>();
		}
		return mLocation;
	}

	/**
	 * Gets the value of the count property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Integer }
	 *     
	 */
	public int getCount() {
		return mCount;
	}

	/**
	 * Sets the value of the count property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Integer }
	 *     
	 */
	public void setCount(int value) {
		mCount = value;
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
		dest.writeString(mQuery);
		if (mLocation != null && mLocation.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mLocation);
		} else
			dest.writeInt(0);
		dest.writeInt(mCount);
	}

	public static final Parcelable.Creator<LocationListType> CREATOR = new Parcelable.Creator<LocationListType>() {
		public LocationListType createFromParcel(Parcel in) {
			return new LocationListType(in);
		}

		public LocationListType[] newArray(int size) {
			return new LocationListType[size];
		}
	};

	private LocationListType(Parcel dest) {
		mQuery = dest.readString();
		if (dest.readInt() == 1) {
			mLocation = new ArrayList<PointType>();
			dest.readTypedList(mLocation, PointType.CREATOR);
		}
		mCount = dest.readInt();
	}
}
