package com.fixedd.AndroidTrimet.schemas.Arrivals;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for tripType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tripType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="progress" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="destDist" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dir" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="tripNum" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="pattern" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class TripType implements Parcelable {

    protected int progress;
    protected int destDist;
    protected int route;
    protected int dir;
    protected int tripNum;
    protected int pattern;
    protected String desc;

    /**
     * Gets the value of the progress property.
     * 
     */
    public int getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     */
    public void setProgress(int value) {
        this.progress = value;
    }

    /**
     * Gets the value of the destDist property.
     * 
     */
    public int getDestDist() {
        return destDist;
    }

    /**
     * Sets the value of the destDist property.
     * 
     */
    public void setDestDist(int value) {
        this.destDist = value;
    }

    /**
     * Gets the value of the route property.
     * 
     */
    public int getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     */
    public void setRoute(int value) {
        this.route = value;
    }

    /**
     * Gets the value of the dir property.
     * 
     */
    public int getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     */
    public void setDir(int value) {
        this.dir = value;
    }

    /**
     * Gets the value of the tripNum property.
     * 
     */
    public int getTripNum() {
        return tripNum;
    }

    /**
     * Sets the value of the tripNum property.
     * 
     */
    public void setTripNum(int value) {
        this.tripNum = value;
    }

    /**
     * Gets the value of the pattern property.
     * 
     */
    public int getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     */
    public void setPattern(int value) {
        this.pattern = value;
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

    

    // **********************************************
    //  for implementing Parcelable
    // **********************************************
    
    
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(progress);
		dest.writeInt(destDist);
		dest.writeInt(route);
		dest.writeInt(dir);
		dest.writeInt(tripNum);
		dest.writeInt(pattern);
		dest.writeString(desc);
	}

	public static final Parcelable.Creator<TripType> CREATOR = new Parcelable.Creator<TripType>() {
		public TripType createFromParcel(Parcel in) {
			return new TripType(in);
		}

		public TripType[] newArray(int size) {
			return new TripType[size];
		}
	};
	
	private TripType(Parcel dest) {
		progress = dest.readInt();
	    destDist = dest.readInt();
	    route    = dest.readInt();
	    dir      = dest.readInt();
	    tripNum  = dest.readInt();
	    pattern  = dest.readInt();
	    desc     = dest.readString();
	}
}
