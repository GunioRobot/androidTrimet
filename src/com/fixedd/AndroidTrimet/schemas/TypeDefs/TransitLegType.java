package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for TransitLegType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitLegType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://maps.trimet.org/maps/model/xml}LegType">
 *       &lt;sequence>
 *         &lt;element name="route" type="{http://maps.trimet.org/maps/model/xml}RouteType"/>
 *         &lt;element name="fare" type="{http://maps.trimet.org/maps/model/xml}FareType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class TransitLegType extends LegType implements Parcelable {
    protected RouteType route;
    protected FareType fare;

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link RouteType }
     *     
     */
    public RouteType getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link RouteType }
     *     
     */
    public void setRoute(RouteType value) {
        this.route = value;
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


    // **********************************************
    //  for implementing Parcelable
    // **********************************************
    
    
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(route       , flags);
		dest.writeParcelable(fare        , flags);
		dest.writeParcelable(timeDistance, flags);
		dest.writeParcelable(lineURL     , flags);
		dest.writeParcelable(from        , flags);
		dest.writeParcelable(to          , flags);
	    dest.writeString(order.value());
	    dest.writeString(id           );
	    dest.writeString(mode         );
	}

	public static final Parcelable.Creator<TransitLegType> CREATOR = new Parcelable.Creator<TransitLegType>() {
		public TransitLegType createFromParcel(Parcel in) {
			return new TransitLegType(in);
		}

		public TransitLegType[] newArray(int size) {
			return new TransitLegType[size];
		}
	};
	
	private TransitLegType(Parcel dest) {
		route        = (RouteType       ) dest.readParcelable(null);
	    fare         = (FareType        ) dest.readParcelable(null);
	    timeDistance = (TimeDistanceType) dest.readParcelable(null);
	    lineURL      = (GeoURLType      ) dest.readParcelable(null);
	    from         = (PointType       ) dest.readParcelable(null);
	    to           = (PointType       ) dest.readParcelable(null);
	    order = OrderType.fromValue(dest.readString());
	    id    = dest.readString();
	    mode  = dest.readString();
	}
}
