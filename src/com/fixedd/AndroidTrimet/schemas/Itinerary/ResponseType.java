package com.fixedd.AndroidTrimet.schemas.Itinerary;

import android.os.Parcel;
import android.os.Parcelable;

import com.fixedd.AndroidTrimet.schemas.TypeDefs.ErrorType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.PointType;
import com.fixedd.AndroidTrimet.schemas.TypeDefs.RequestType;

/**
 * <p>Java class for ResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="request" type="{http://maps.trimet.org/maps/model/xml}RequestType"/>
 *         &lt;element name="from" type="{http://maps.trimet.org/maps/model/xml}PointType" minOccurs="0"/>
 *         &lt;element name="to" type="{http://maps.trimet.org/maps/model/xml}PointType" minOccurs="0"/>
 *         &lt;element name="itineraries" type="{http://maps.trimet.org/maps/model/xml}ItinerariesType" minOccurs="0"/>
 *         &lt;element name="locations" type="{http://maps.trimet.org/maps/model/xml}LocationListType" minOccurs="0"/>
 *         &lt;element name="fromList" type="{http://maps.trimet.org/maps/model/xml}LocationListType" minOccurs="0"/>
 *         &lt;element name="toList" type="{http://maps.trimet.org/maps/model/xml}LocationListType" minOccurs="0"/>
 *         &lt;element name="walkingDirections" type="{http://maps.trimet.org/maps/model/xml}WalkingDirectionsType"/>
 *         &lt;element name="error" type="{http://maps.trimet.org/maps/model/xml}ErrorType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ResponseType implements Parcelable {

	protected String				mDate				= "";
	protected String				mTime				= "";
	protected RequestType			mRequest;
	protected PointType				mFrom;
	protected PointType				mTo;
	protected ItinerariesType		mItineraries;
	protected LocationListType		mLocations;
	protected LocationListType		mFromList;
	protected LocationListType		mToList;
	protected WalkingDirectionsType	mWalkingDirections;
	protected ErrorType				mError;
	protected boolean				mSuccess			= false;

	/**
	 * Create a new, empty copy of this object.
	 */
	public ResponseType() {}

	/**
	 * Gets the value of the date property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDate() {
		return mDate;
	}

	/**
	 * Sets the value of the date property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDate(String value) {
		mDate = value;
	}

	/**
	 * Gets the value of the time property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTime() {
		return mTime;
	}

	/**
	 * Sets the value of the time property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTime(String value) {
		mTime = value;
	}

	/**
	 * Gets the value of the request property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link RequestType }
	 *     
	 */
	public RequestType getRequest() {
		return mRequest;
	}

	/**
	 * Sets the value of the request property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link RequestType }
	 *     
	 */
	public void setRequest(RequestType value) {
		mRequest = value;
	}

	/**
	 * Gets the value of the from property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link PointType }
	 *     
	 */
	public PointType getFrom() {
		return mFrom;
	}

	/**
	 * Sets the value of the from property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link PointType }
	 *     
	 */
	public void setFrom(PointType value) {
		mFrom = value;
	}

	/**
	 * Gets the value of the to property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link PointType }
	 *     
	 */
	public PointType getTo() {
		return mTo;
	}

	/**
	 * Sets the value of the to property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link PointType }
	 *     
	 */
	public void setTo(PointType value) {
		mTo = value;
	}

	/**
	 * Gets the value of the itineraries property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link ItinerariesType }
	 *     
	 */
	public ItinerariesType getItineraries() {
		return mItineraries;
	}

	/**
	 * Sets the value of the itineraries property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link ItinerariesType }
	 *     
	 */
	public void setItineraries(ItinerariesType value) {
		mItineraries = value;
	}

	/**
	 * Gets the value of the locations property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link LocationListType }
	 *     
	 */
	public LocationListType getLocations() {
		return mLocations;
	}

	/**
	 * Sets the value of the locations property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link LocationListType }
	 *     
	 */
	public void setLocations(LocationListType value) {
		mLocations = value;
	}

	/**
	 * Gets the value of the fromList property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link LocationListType }
	 *     
	 */
	public LocationListType getFromList() {
		return mFromList;
	}

	/**
	 * Sets the value of the fromList property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link LocationListType }
	 *     
	 */
	public void setFromList(LocationListType value) {
		mFromList = value;
	}

	/**
	 * Gets the value of the toList property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link LocationListType }
	 *     
	 */
	public LocationListType getToList() {
		return mToList;
	}

	/**
	 * Sets the value of the toList property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link LocationListType }
	 *     
	 */
	public void setToList(LocationListType value) {
		mToList = value;
	}

	/**
	 * Gets the value of the walkingDirections property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link WalkingDirectionsType }
	 *     
	 */
	public WalkingDirectionsType getWalkingDirections() {
		return mWalkingDirections;
	}

	/**
	 * Sets the value of the walkingDirections property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link WalkingDirectionsType }
	 *     
	 */
	public void setWalkingDirections(WalkingDirectionsType value) {
		mWalkingDirections = value;
	}

	/**
	 * Gets the value of the error property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link ErrorType }
	 *     
	 */
	public ErrorType getError() {
		return mError;
	}

	/**
	 * Sets the value of the error property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link ErrorType }
	 *     
	 */
	public void setError(ErrorType value) {
		mError = value;
	}

	/**
	 * Gets the value of the success property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public boolean isSuccess() {
		return mSuccess;
	}

	/**
	 * Sets the value of the success property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setSuccess(boolean value) {
		mSuccess = value;
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
		dest.writeString(mDate);
		dest.writeString(mTime);
		if (mRequest != null) {
			dest.writeInt(1);
			dest.writeParcelable(mRequest, flags);
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
		if (mItineraries != null) {
			dest.writeInt(1);
			dest.writeParcelable(mItineraries, flags);
		} else 
			dest.writeInt(0);
		if (mLocations != null) {
			dest.writeInt(1);
			dest.writeParcelable(mLocations, flags);
		} else 
			dest.writeInt(0);
		if (mFromList != null) {
			dest.writeInt(1);
			dest.writeParcelable(mFromList, flags);
		} else 
			dest.writeInt(0);
		if (mToList != null) {
			dest.writeInt(1);
			dest.writeParcelable(mToList, flags);
		} else 
			dest.writeInt(0);
		if (mWalkingDirections != null) {
			dest.writeInt(1);
			dest.writeParcelable(mWalkingDirections, flags);
		} else 
			dest.writeInt(0);
		if (mError != null) {
			dest.writeInt(1);
			dest.writeParcelable(mError, flags);
		} else 
			dest.writeInt(0);
		dest.writeString(Boolean.toString(mSuccess));
	}

	public static final Parcelable.Creator<ResponseType> CREATOR = new Parcelable.Creator<ResponseType>() {
		public ResponseType createFromParcel(Parcel in) {
			return new ResponseType(in);
		}

		public ResponseType[] newArray(int size) {
			return new ResponseType[size];
		}
	};

	private ResponseType(Parcel dest) {
		mDate = dest.readString();
		mTime = dest.readString();
		if (dest.readInt() == 1) mRequest           = (RequestType          ) dest.readParcelable(null);
		if (dest.readInt() == 1) mFrom              = (PointType            ) dest.readParcelable(null);
		if (dest.readInt() == 1) mTo                = (PointType            ) dest.readParcelable(null);
		if (dest.readInt() == 1) mItineraries       = (ItinerariesType      ) dest.readParcelable(null);
		if (dest.readInt() == 1) mLocations         = (LocationListType     ) dest.readParcelable(null);
		if (dest.readInt() == 1) mFromList          = (LocationListType     ) dest.readParcelable(null);
		if (dest.readInt() == 1) mToList            = (LocationListType     ) dest.readParcelable(null);
		if (dest.readInt() == 1) mWalkingDirections = (WalkingDirectionsType) dest.readParcelable(null);
		if (dest.readInt() == 1) mError             = (ErrorType            ) dest.readParcelable(null);
		mSuccess = Boolean.parseBoolean(dest.readString());
	}
}
