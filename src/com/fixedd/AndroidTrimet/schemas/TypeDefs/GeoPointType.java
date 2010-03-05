package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for GeoPointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoPointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="srsName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class GeoPointType extends PointType implements Parcelable {

	protected String	mX			= "";
	protected String	mY			= "";
	protected String	mLat		= "";
	protected String	mLon		= "";
	protected String	mSrsName	= "";
	protected String	mId			= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public GeoPointType() {}

	/**
	 * Gets the value of the x property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getX() {
		return mX;
	}

	/**
	 * Sets the value of the x property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setX(String value) {
		mX = value;
	}

	/**
	 * Gets the value of the y property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getY() {
		return mY;
	}

	/**
	 * Sets the value of the y property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setY(String value) {
		mY = value;
	}

	/**
	 * Gets the value of the lat property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getLat() {
		return mLat;
	}

	/**
	 * Sets the value of the lat property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setLat(String value) {
		mLat = value;
	}

	/**
	 * Gets the value of the lon property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getLon() {
		return mLon;
	}

	/**
	 * Sets the value of the lon property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setLon(String value) {
		mLon = value;
	}

	/**
	 * Gets the value of the srsName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSrsName() {
		return mSrsName;
	}

	/**
	 * Sets the value of the srsName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSrsName(String value) {
		mSrsName = value;
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
		// from PointType
		if (mPos != null) {
			dest.writeInt(1);
			dest.writeParcelable(mPos, flags);
		} else
			dest.writeInt(0);
		dest.writeString(mDescription);
		dest.writeString(mAreaKey    );
		dest.writeString(mAreaValue  );
		dest.writeString(mId         );
		
		// from GeoPointType
		dest.writeString(mX      );
		dest.writeString(mY      );
		dest.writeString(mLat    );
		dest.writeString(mLon    );
		dest.writeString(mSrsName);
		dest.writeString(mId     );
	}

	public static final Parcelable.Creator<GeoPointType> CREATOR = new Parcelable.Creator<GeoPointType>() {
		public GeoPointType createFromParcel(Parcel in) {
			return new GeoPointType(in);
		}

		public GeoPointType[] newArray(int size) {
			return new GeoPointType[size];
		}
	};

	private GeoPointType(Parcel dest) {
		// from PointType
		if (dest.readInt() == 1) mPos = (GeoPointType) dest.readParcelable(getClass().getClassLoader());
		mDescription = dest.readString();
		mAreaKey     = dest.readString();
		mAreaValue   = dest.readString();
		mId          = dest.readString();
		
		// from GeoPointType
		mX       = dest.readString();
		mY       = dest.readString();
		mLat     = dest.readString();
		mLon     = dest.readString();
		mSrsName = dest.readString();
		mId      = dest.readString();
		
	}
}
