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

    protected String number;
    protected String internalNumber;
    protected String direction;

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
        return number;
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
        this.number = value;
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
        return internalNumber;
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
        this.internalNumber = value;
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
        return direction;
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
        this.direction = value;
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
		dest.writeString(number        );
	    dest.writeString(internalNumber);
		dest.writeString(direction     );
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
		number         = dest.readString();
	    internalNumber = dest.readString();
	    direction      = dest.readString();
	}
}
