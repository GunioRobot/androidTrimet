package com.fixedd.AndroidTrimet.schemas.Itinerary;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.fixedd.AndroidTrimet.schemas.TypeDefs.OrderedStringsType;


/**
 * <p>Java class for WalkingDirectionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WalkingDirectionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="turn" type="{http://maps.trimet.org/maps/model/xml}OrderedStringsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class WalkingDirectionsType implements Parcelable {

    protected List<OrderedStringsType> turn;
    protected double distance;
    protected Integer count;

    /**
     * Gets the value of the turn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the turn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTurn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderedStringsType }
     * 
     * 
     */
    public List<OrderedStringsType> getTurn() {
        if (turn == null) {
            turn = new ArrayList<OrderedStringsType>();
        }
        return this.turn;
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
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
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
		dest.writeTypedList(turn    );
	    dest.writeDouble   (distance);
	    dest.writeInt      (count   );
	}

	public static final Parcelable.Creator<WalkingDirectionsType> CREATOR = new Parcelable.Creator<WalkingDirectionsType>() {
		public WalkingDirectionsType createFromParcel(Parcel in) {
			return new WalkingDirectionsType(in);
		}

		public WalkingDirectionsType[] newArray(int size) {
			return new WalkingDirectionsType[size];
		}
	};
	
	private WalkingDirectionsType(Parcel dest) {
		dest.readTypedList(turn, OrderedStringsType.CREATOR);
		distance = dest.readDouble();
		count    = dest.readInt();
	}
}
