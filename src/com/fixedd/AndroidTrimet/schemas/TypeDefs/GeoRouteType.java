package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for GeoRouteType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeoRouteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ogcFilter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfsUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wmsUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
public class GeoRouteType implements Parcelable {

	protected String	mDomain		= "";
	protected String	mTypeName	= "";
	protected String	mOgcFilter	= "";
	protected String	mWfsUrl		= "";
	protected String	mWmsUrl		= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public GeoRouteType() {}

	/**
	 * Gets the value of the domain property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getDomain() {
		return mDomain;
	}

	/**
	 * Sets the value of the domain property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setDomain(String value) {
		mDomain = value;
	}

	/**
	 * Gets the value of the typeName property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getTypeName() {
		return mTypeName;
	}

	/**
	 * Sets the value of the typeName property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setTypeName(String value) {
		mTypeName = value;
	}

	/**
	 * Gets the value of the ogcFilter property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getOgcFilter() {
		return mOgcFilter;
	}

	/**
	 * Sets the value of the ogcFilter property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setOgcFilter(String value) {
		mOgcFilter = value;
	}

	/**
	 * Gets the value of the wfsUrl property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getWfsUrl() {
		return mWfsUrl;
	}

	/**
	 * Sets the value of the wfsUrl property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setWfsUrl(String value) {
		mWfsUrl = value;
	}

	/**
	 * Gets the value of the wmsUrl property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getWmsUrl() {
		return mWmsUrl;
	}

	/**
	 * Sets the value of the wmsUrl property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setWmsUrl(String value) {
		mWmsUrl = value;
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
		dest.writeString(mDomain   );
		dest.writeString(mTypeName );
		dest.writeString(mOgcFilter);
		dest.writeString(mWfsUrl   );
		dest.writeString(mWmsUrl   );
	}

	public static final Parcelable.Creator<GeoRouteType> CREATOR = new Parcelable.Creator<GeoRouteType>() {
		public GeoRouteType createFromParcel(Parcel in) {
			return new GeoRouteType(in);
		}

		public GeoRouteType[] newArray(int size) {
			return new GeoRouteType[size];
		}
	};

	private GeoRouteType(Parcel dest) {
		mDomain    = dest.readString();
		mTypeName  = dest.readString();
		mOgcFilter = dest.readString();
		mWfsUrl    = dest.readString();
		mWmsUrl    = dest.readString();
	}
}
