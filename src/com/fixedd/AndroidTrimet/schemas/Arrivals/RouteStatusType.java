package com.fixedd.AndroidTrimet.schemas.Arrivals;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for routeStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteStatusType implements Parcelable {

    protected int route;
    protected String status;

    public RouteStatusType() {}
    
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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
		dest.writeInt(route);
		dest.writeString(status);
	}

	public static final Parcelable.Creator<RouteStatusType> CREATOR = new Parcelable.Creator<RouteStatusType>() {
		public RouteStatusType createFromParcel(Parcel in) {
			return new RouteStatusType(in);
		}

		public RouteStatusType[] newArray(int size) {
			return new RouteStatusType[size];
		}
	};
	
	private RouteStatusType(Parcel dest) {
		route  = dest.readInt();
	    status = dest.readString();
	}
}
