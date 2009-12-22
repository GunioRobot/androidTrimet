package com.fixedd.AndroidTrimet.schemas.Arrivals;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * <p>Java class for layoverType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="layoverType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{urn:trimet:arrivals}locationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="start" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="end" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class LayoverType implements Parcelable {

    protected LocationType location;
    protected long start;
    protected long end;

    public LayoverType() {}
    
    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the start property.
     * 
     */
    public long getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     */
    public void setStart(long value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     */
    public long getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     */
    public void setEnd(long value) {
        this.end = value;
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
		dest.writeParcelable(location, flags);
	    dest.writeLong(start);
	    dest.writeLong(end  );
	}

	public static final Parcelable.Creator<LayoverType> CREATOR = new Parcelable.Creator<LayoverType>() {
		public LayoverType createFromParcel(Parcel in) {
			return new LayoverType(in);
		}

		public LayoverType[] newArray(int size) {
			return new LayoverType[size];
		}
	};
	
	private LayoverType(Parcel dest) {
		location = (LocationType) dest.readParcelable(null);
	    start = dest.readLong();
	    end   = dest.readLong();
	}
}
