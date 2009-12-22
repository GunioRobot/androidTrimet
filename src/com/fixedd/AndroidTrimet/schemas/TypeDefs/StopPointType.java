package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.fixedd.AndroidTrimet.util.ParcelableString;


/**
 * <p>Java class for StopPointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopPointType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://maps.trimet.org/maps/model/xml}PointType">
 *       &lt;sequence>
 *         &lt;element name="stopId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streetPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fareZone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stopSequence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="30" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class StopPointType extends PointType implements Parcelable {

    protected String stopId;
    protected String streetPosition;
    protected String fareZone;
    protected int stopSequence;
    protected double distance;
    protected List<ParcelableString> comment;

    /**
     * Gets the value of the stopId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopId() {
        return stopId;
    }

    /**
     * Sets the value of the stopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopId(String value) {
        this.stopId = value;
    }

    /**
     * Gets the value of the streetPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetPosition() {
        return streetPosition;
    }

    /**
     * Sets the value of the streetPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetPosition(String value) {
        this.streetPosition = value;
    }

    /**
     * Gets the value of the fareZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareZone() {
        return fareZone;
    }

    /**
     * Sets the value of the fareZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareZone(String value) {
        this.fareZone = value;
    }

    /**
     * Gets the value of the stopSequence property.
     * 
     */
    public int getStopSequence() {
        return stopSequence;
    }

    /**
     * Sets the value of the stopSequence property.
     * 
     */
    public void setStopSequence(int value) {
        this.stopSequence = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<ParcelableString> getComment() {
        if (comment == null) {
            comment = new ArrayList<ParcelableString>();
        }
        return this.comment;
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
		dest.writeString(stopId        );
		dest.writeString(streetPosition);
		dest.writeString(fareZone      );
		dest.writeInt   (stopSequence  );
		dest.writeDouble(distance      );
		dest.writeTypedList(comment);
		// from PointType
		dest.writeParcelable(pos, flags);
	    dest.writeString(description);
	    dest.writeString(areaKey    );
	    dest.writeString(areaValue  );
	    dest.writeString(id         );
	}

	public static final Parcelable.Creator<StopPointType> CREATOR = new Parcelable.Creator<StopPointType>() {
		public StopPointType createFromParcel(Parcel in) {
			return new StopPointType(in);
		}

		public StopPointType[] newArray(int size) {
			return new StopPointType[size];
		}
	};
	
	private StopPointType(Parcel dest) {
		stopId         = dest.readString();
		streetPosition = dest.readString();
		fareZone       = dest.readString();
		stopSequence   = dest.readInt   ();
		distance       = dest.readDouble();
		dest.readTypedList(comment, ParcelableString.CREATOR);
		// from PointType
		pos = (GeoPointType) dest.readParcelable(null);
	    description = dest.readString();
	    areaKey     = dest.readString();
	    areaValue   = dest.readString();
	    id          = dest.readString();
	}
}
