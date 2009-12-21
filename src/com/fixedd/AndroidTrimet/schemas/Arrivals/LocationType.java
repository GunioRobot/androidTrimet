package com.fixedd.AndroidTrimet.schemas.Arrivals;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for locationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="locationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="locid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dir" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lat" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="lng" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class LocationType implements Parcelable {

    protected int locid;
    protected String desc;
    protected String dir;
    protected double lat;
    protected double lng;

    /**
     * Gets the value of the locid property.
     * 
     */
    public int getLocid() {
        return locid;
    }

    /**
     * Sets the value of the locid property.
     * 
     */
    public void setLocid(int value) {
        this.locid = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the dir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDir(String value) {
        this.dir = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lng property.
     * 
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the value of the lng property.
     * 
     */
    public void setLng(double value) {
        this.lng = value;
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
		dest.writeInt   (locid);
	    dest.writeString(desc );
	    dest.writeString(dir  );
	    dest.writeDouble(lat  );
	    dest.writeDouble(lng  );
	}

	public static final Parcelable.Creator<LocationType> CREATOR = new Parcelable.Creator<LocationType>() {
		public LocationType createFromParcel(Parcel in) {
			return new LocationType(in);
		}

		public LocationType[] newArray(int size) {
			return new LocationType[size];
		}
	};
	
	private LocationType(Parcel dest) {
		locid = dest.readInt   ();
	    desc  = dest.readString();
	    dir   = dest.readString();
	    lat   = dest.readDouble();
	    lng   = dest.readDouble();
	}
}
