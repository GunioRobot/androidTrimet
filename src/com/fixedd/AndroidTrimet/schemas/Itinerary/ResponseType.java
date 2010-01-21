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

    protected String date;
    protected String time;
    protected RequestType request;
    protected PointType from;
    protected PointType to;
    protected ItinerariesType itineraries;
    protected LocationListType locations;
    protected LocationListType fromList;
    protected LocationListType toList;
    protected WalkingDirectionsType walkingDirections;
    protected ErrorType error;
    protected Boolean success;

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
        return date;
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
        this.date = value;
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
        return time;
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
        this.time = value;
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
        return request;
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
        this.request = value;
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
        return from;
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
        this.from = value;
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
        return to;
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
        this.to = value;
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
        return itineraries;
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
        this.itineraries = value;
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
        return locations;
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
        this.locations = value;
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
        return fromList;
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
        this.fromList = value;
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
        return toList;
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
        this.toList = value;
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
        return walkingDirections;
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
        this.walkingDirections = value;
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
        return error;
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
        this.error = value;
    }

    /**
     * Gets the value of the success property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuccess(Boolean value) {
        this.success = value;
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
		dest.writeString(date);
		dest.writeString(time);
	    dest.writeParcelable(request          , flags);
	    dest.writeParcelable(from             , flags);
	    dest.writeParcelable(to               , flags);
	    dest.writeParcelable(itineraries      , flags);
	    dest.writeParcelable(locations        , flags);
	    dest.writeParcelable(fromList         , flags);
	    dest.writeParcelable(toList           , flags);
	    dest.writeParcelable(walkingDirections, flags);
	    dest.writeParcelable(error            , flags);
	    dest.writeString(Boolean.toString(success));
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
		date = dest.readString();
	    time = dest.readString();
	    request           = (RequestType          ) dest.readParcelable(null);
	    from              = (PointType            ) dest.readParcelable(null);
	    to                = (PointType            ) dest.readParcelable(null);
	    itineraries       = (ItinerariesType      ) dest.readParcelable(null);
	    locations         = (LocationListType     ) dest.readParcelable(null);
	    fromList          = (LocationListType     ) dest.readParcelable(null);
	    toList            = (LocationListType     ) dest.readParcelable(null);
	    walkingDirections = (WalkingDirectionsType) dest.readParcelable(null);
	    error             = (ErrorType            ) dest.readParcelable(null);
	    success = Boolean.parseBoolean(dest.readString());
	}
}
