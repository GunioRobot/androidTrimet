package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for SpecialFareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecialFareType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="id" use="required" type="{http://maps.trimet.org/maps/model/xml}FareIdType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class SpecialFareType implements Parcelable {

	protected String	mValue	= "";
	protected String	mId		= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public SpecialFareType() {}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getValue() {
		return mValue;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setValue(String value) {
		mValue = value;
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


	// **********************************************
	//  for implementing Parcelable
	// **********************************************


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mValue);
		dest.writeString(mId   );
	}

	public static final Parcelable.Creator<SpecialFareType> CREATOR = new Parcelable.Creator<SpecialFareType>() {
		public SpecialFareType createFromParcel(Parcel in) {
			return new SpecialFareType(in);
		}

		public SpecialFareType[] newArray(int size) {
			return new SpecialFareType[size];
		}
	};

	private SpecialFareType(Parcel dest) {
		mValue = dest.readString();
		mId    = dest.readString();
	}
}
