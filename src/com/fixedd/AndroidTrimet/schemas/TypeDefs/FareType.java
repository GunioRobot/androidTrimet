package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for FareType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="regular" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="special" type="{http://maps.trimet.org/maps/model/xml}SpecialFareType" maxOccurs="10" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="provider" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
public class FareType implements Parcelable {
	protected String				mRegular	= "";
	protected List<SpecialFareType>	mSpecial;
	protected String				mProvider	= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public FareType() {}

	/**
	 * Gets the value of the regular property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getRegular() {
		return mRegular;
	}

	/**
	 * Sets the value of the regular property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setRegular(String value) {
		mRegular = value;
	}

	/**
	 * Gets the value of the special property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the special property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getSpecial().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SpecialFareType }
	 *
	 *
	 */
	public List<SpecialFareType> getSpecial() {
		if (mSpecial == null) {
			mSpecial = new ArrayList<SpecialFareType>();
		}
		return mSpecial;
	}

	/**
	 * Gets the value of the provider property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getProvider() {
		return mProvider;
	}

	/**
	 * Sets the value of the provider property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setProvider(String value) {
		mProvider = value;
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
		dest.writeString(mRegular);
		if (mSpecial != null && mSpecial.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mSpecial);
		} else
			dest.writeInt(0);
		dest.writeString(mProvider);
	}

	public static final Parcelable.Creator<FareType> CREATOR = new Parcelable.Creator<FareType>() {
		public FareType createFromParcel(Parcel in) {
			return new FareType(in);
		}

		public FareType[] newArray(int size) {
			return new FareType[size];
		}
	};

	private FareType(Parcel dest) {
		mRegular = dest.readString();
		if (dest.readInt() == 1) {
			mSpecial = new ArrayList<SpecialFareType>();
			dest.readTypedList(mSpecial, SpecialFareType.CREATOR);
		}
		mProvider = dest.readString();
	}
}
