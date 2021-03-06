package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for GeoURLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoURLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="param" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class GeoURLType implements Parcelable {
	protected String	mUrl	= "";
	protected String	mParam	= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public GeoURLType() {}

	/**
	 * Gets the value of the url property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUrl() {
		return mUrl;
	}

	/**
	 * Sets the value of the url property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setUrl(String value) {
		mUrl = value;
	}

	/**
	 * Gets the value of the param property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getParam() {
		return mParam;
	}

	/**
	 * Sets the value of the param property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setParam(String value) {
		mParam = value;
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
		dest.writeString(mUrl  );
		dest.writeString(mParam);
	}

	public static final Parcelable.Creator<GeoURLType> CREATOR = new Parcelable.Creator<GeoURLType>() {
		public GeoURLType createFromParcel(Parcel in) {
			return new GeoURLType(in);
		}

		public GeoURLType[] newArray(int size) {
			return new GeoURLType[size];
		}
	};

	private GeoURLType(Parcel dest) {
		mUrl   = dest.readString();
		mParam = dest.readString();
	}
}
