package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for ItineraryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItineraryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time-distance" type="{http://maps.trimet.org/maps/model/xml}TimeDistanceType"/>
 *         &lt;element name="fare" type="{http://maps.trimet.org/maps/model/xml}FareType"/>
 *         &lt;element name="routes" type="{http://maps.trimet.org/maps/model/xml}RouteSummaryType"/>
 *         &lt;element name="leg" type="{http://maps.trimet.org/maps/model/xml}LegType" maxOccurs="unbounded"/>
 *         &lt;element name="geo" type="{http://maps.trimet.org/maps/model/xml}GeoRouteType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="viaRoute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ItineraryType implements Parcelable {

    protected TimeDistanceType timeDistance;
    protected FareType fare;
    protected RouteSummaryType routes;
    protected List<LegType> leg;
    protected List<GeoRouteType> geo;
    protected String id;
    protected String viaRoute;

    /**
     * Gets the value of the timeDistance property.
     * 
     * @return
     *     possible object is
     *     {@link TimeDistanceType }
     *     
     */
    public TimeDistanceType getTimeDistance() {
        return timeDistance;
    }

    /**
     * Sets the value of the timeDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeDistanceType }
     *     
     */
    public void setTimeDistance(TimeDistanceType value) {
        this.timeDistance = value;
    }

    /**
     * Gets the value of the fare property.
     * 
     * @return
     *     possible object is
     *     {@link FareType }
     *     
     */
    public FareType getFare() {
        return fare;
    }

    /**
     * Sets the value of the fare property.
     * 
     * @param value
     *     allowed object is
     *     {@link FareType }
     *     
     */
    public void setFare(FareType value) {
        this.fare = value;
    }

    /**
     * Gets the value of the routes property.
     * 
     * @return
     *     possible object is
     *     {@link RouteSummaryType }
     *     
     */
    public RouteSummaryType getRoutes() {
        return routes;
    }

    /**
     * Sets the value of the routes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteSummaryType }
     *     
     */
    public void setRoutes(RouteSummaryType value) {
        this.routes = value;
    }

    /**
     * Gets the value of the leg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLeg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegType }
     * 
     * 
     */
    public List<LegType> getLeg() {
        if (leg == null) {
            leg = new ArrayList<LegType>();
        }
        return this.leg;
    }

    /**
     * Gets the value of the geo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeoRouteType }
     * 
     * 
     */
    public List<GeoRouteType> getGeo() {
        if (geo == null) {
            geo = new ArrayList<GeoRouteType>();
        }
        return this.geo;
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
        return id;
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
        this.id = value;
    }

    /**
     * Gets the value of the viaRoute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViaRoute() {
        return viaRoute;
    }

    /**
     * Sets the value of the viaRoute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViaRoute(String value) {
        this.viaRoute = value;
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
		dest.writeParcelable(timeDistance, flags);
		dest.writeParcelable(fare        , flags);
		dest.writeParcelable(routes      , flags);
		dest.writeTypedList(leg     );
		dest.writeTypedList(geo     );
	    dest.writeString   (id      );
	    dest.writeString   (viaRoute);
	}

	public static final Parcelable.Creator<ItineraryType> CREATOR = new Parcelable.Creator<ItineraryType>() {
		public ItineraryType createFromParcel(Parcel in) {
			return new ItineraryType(in);
		}

		public ItineraryType[] newArray(int size) {
			return new ItineraryType[size];
		}
	};
	
	public ItineraryType(Parcel dest) {
		timeDistance = (TimeDistanceType) dest.readParcelable(null);
	    fare         = (FareType        ) dest.readParcelable(null);
	    routes       = (RouteSummaryType) dest.readParcelable(null);
	    dest.readTypedList(leg, LegType     .CREATOR);
	    dest.readTypedList(geo, GeoRouteType.CREATOR);
	    id       = dest.readString();
	    viaRoute = dest.readString();
	}
}
