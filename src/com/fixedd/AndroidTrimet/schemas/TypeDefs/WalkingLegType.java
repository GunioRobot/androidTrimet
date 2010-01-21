package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for WalkingLegType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WalkingLegType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://maps.trimet.org/maps/model/xml}LegType">
 *       &lt;sequence>
 *         &lt;element name="direction" type="{http://maps.trimet.org/maps/model/xml}DirType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class WalkingLegType extends LegType implements Parcelable {

    protected String direction;

    /**
     * Create a new, empty copy of this object.
     */
    public WalkingLegType() {}
    
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
		dest.writeString(direction);
		dest.writeString(id       );
	    dest.writeString(mode     );
		dest.writeParcelable(timeDistance, flags);
		dest.writeParcelable(lineURL     , flags);
	    dest.writeParcelable(from        , flags);
	    dest.writeParcelable(to          , flags);
	    dest.writeString(order.value());
	}

	public static final Parcelable.Creator<WalkingLegType> CREATOR = new Parcelable.Creator<WalkingLegType>() {
		public WalkingLegType createFromParcel(Parcel in) {
			return new WalkingLegType(in);
		}

		public WalkingLegType[] newArray(int size) {
			return new WalkingLegType[size];
		}
	};
	
	private WalkingLegType(Parcel dest) {
		direction = dest.readString();
		id        = dest.readString();
		mode      = dest.readString();
		timeDistance = (TimeDistanceType) dest.readParcelable(null);
		lineURL      = (GeoURLType      ) dest.readParcelable(null);
		from         = (PointType       ) dest.readParcelable(null);
		to           = (PointType       ) dest.readParcelable(null);
		order = OrderType.fromValue(dest.readString());
	}
}
