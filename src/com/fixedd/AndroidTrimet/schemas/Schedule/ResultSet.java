package com.fixedd.AndroidTrimet.schemas.Schedule;

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
 *         &lt;element name="route" type="{urn:trimet:schedule}routeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detour" type="{urn:trimet:schedule}detourType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ResultSet implements Parcelable {

    protected String errorMessage;
    protected List<RouteType> route;
    protected List<DetourType> detour;

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
     * Gets the value of the route property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the route property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteType }
     * 
     * 
     */
    public List<RouteType> getRoute() {
        if (route == null) {
            route = new ArrayList<RouteType>();
        }
        return this.route;
    }

    /**
     * Gets the value of the detour property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detour property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetour().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetourType }
     * 
     * 
     */
    public List<DetourType> getDetour() {
        if (detour == null) {
            detour = new ArrayList<DetourType>();
        }
        return this.detour;
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
	    dest.writeTypedList(route       );
	    dest.writeTypedList(detour      );
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
	    dest.readTypedList(route , RouteType .CREATOR);
	    dest.readTypedList(detour, DetourType.CREATOR);
	}
}
