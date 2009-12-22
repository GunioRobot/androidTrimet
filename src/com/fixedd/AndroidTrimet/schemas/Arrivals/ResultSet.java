package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * <p>Java class for resultSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:trimet:arrivals}locationType" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="arrival" type="{urn:trimet:arrivals}arrivalType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeStatus" type="{urn:trimet:arrivals}routeStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="queryTime" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ResultSet implements Parcelable {

    protected String errorMessage;
    protected List<LocationType> location;
    protected List<ArrivalType> arrival;
    protected List<RouteStatusType> routeStatus;
    protected Long queryTime;

    public ResultSet() {}
    
    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the location property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getLocation() {
        if (location == null) {
            location = new ArrayList<LocationType>();
        }
        return this.location;
    }

    /**
     * Gets the value of the arrival property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrival property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrival().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrivalType }
     * 
     * 
     */
    public List<ArrivalType> getArrival() {
        if (arrival == null) {
            arrival = new ArrayList<ArrivalType>();
        }
        return this.arrival;
    }

    /**
     * Gets the value of the routeStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routeStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRouteStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteStatusType }
     * 
     * 
     */
    public List<RouteStatusType> getRouteStatus() {
        if (routeStatus == null) {
            routeStatus = new ArrayList<RouteStatusType>();
        }
        return this.routeStatus;
    }

    /**
     * Gets the value of the queryTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQueryTime() {
        return queryTime;
    }

    /**
     * Sets the value of the queryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQueryTime(Long value) {
        this.queryTime = value;
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
		dest.writeString   (errorMessage);
		dest.writeTypedList(location    );
		dest.writeTypedList(arrival     );
		dest.writeTypedList(routeStatus );
		dest.writeLong     (queryTime   );
	}

	public static final Parcelable.Creator<ResultSet> CREATOR = new Parcelable.Creator<ResultSet>() {
		public ResultSet createFromParcel(Parcel in) {
			return new ResultSet(in);
		}

		public ResultSet[] newArray(int size) {
			return new ResultSet[size];
		}
	};
	
	private ResultSet(Parcel dest) {
		errorMessage = dest.readString();
	    dest.readTypedList(location   , LocationType   .CREATOR);
	    dest.readTypedList(arrival    , ArrivalType    .CREATOR);
	    dest.readTypedList(routeStatus, RouteStatusType.CREATOR);
	    queryTime    = dest.readLong();
	}
}
