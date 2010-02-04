package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for RouteIdType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteIdType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="internalNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direction" type="{http://maps.trimet.org/maps/model/xml}DirType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteIdType implements Parcelable {

	protected String	mNumber			= "";
	protected String	mInternalNumber	= "";
	protected String	mDirection		= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public RouteIdType() {}

	/**
	 * Gets the value of the number property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getNumber() {
		return mNumber;
	}

	/**
	 * Sets the value of the number property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setNumber(String value) {
		mNumber = value;
	}

	/**
	 * Gets the value of the internalNumber property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getInternalNumber() {
		return mInternalNumber;
	}

	/**
	 * Sets the value of the internalNumber property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setInternalNumber(String value) {
		mInternalNumber = value;
	}

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
		dest.writeString(mNumber        );
		dest.writeString(mInternalNumber);
		dest.writeString(mDirection     );
	}

	public static final Parcelable.Creator<RouteIdType> CREATOR = new Parcelable.Creator<RouteIdType>() {
		public RouteIdType createFromParcel(Parcel in) {
			return new RouteIdType(in);
		}

		public RouteIdType[] newArray(int size) {
			return new RouteIdType[size];
		}
	};

	private RouteIdType(Parcel dest) {
		mNumber         = dest.readString();
		mInternalNumber = dest.readString();
		mDirection      = dest.readString();
	}
}
