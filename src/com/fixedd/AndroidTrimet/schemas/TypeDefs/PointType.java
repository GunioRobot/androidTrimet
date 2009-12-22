package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for PointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pos" type="{http://maps.trimet.org/maps/model/xml}GeoPointType"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="areaKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="areaValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class PointType implements Parcelable {

    protected GeoPointType pos;
    protected String description;
    protected String areaKey;
    protected String areaValue;
    protected String id;

    // unused
    public PointType() {
    	
    }
    
    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link GeoPointType }
     *     
     */
    public GeoPointType getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoPointType }
     *     
     */
    public void setPos(GeoPointType value) {
        this.pos = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the areaKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaKey() {
        return areaKey;
    }

    /**
     * Sets the value of the areaKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaKey(String value) {
        this.areaKey = value;
    }

    /**
     * Gets the value of the areaValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaValue() {
        return areaValue;
    }

    /**
     * Sets the value of the areaValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaValue(String value) {
        this.areaValue = value;
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


    // **********************************************
    //  for implementing Parcelable
    // **********************************************
    
    
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(pos, flags);
	    dest.writeString(description);
	    dest.writeString(areaKey    );
	    dest.writeString(areaValue  );
	    dest.writeString(id         );
	}

	public static final Parcelable.Creator<PointType> CREATOR = new Parcelable.Creator<PointType>() {
		public PointType createFromParcel(Parcel in) {
			return new PointType(in);
		}

		public PointType[] newArray(int size) {
			return new PointType[size];
		}
	};
	
	private PointType(Parcel dest) {
		pos = (GeoPointType) dest.readParcelable(null);
	    description = dest.readString();
	    areaKey     = dest.readString();
	    areaValue   = dest.readString();
	    id          = dest.readString();
	}
}
