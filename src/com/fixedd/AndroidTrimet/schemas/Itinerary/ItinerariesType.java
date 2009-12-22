package com.fixedd.AndroidTrimet.schemas.Itinerary;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.fixedd.AndroidTrimet.schemas.TypeDefs.ItineraryType;


/**
 * <p>Java class for ItinerariesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItinerariesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itinerary" type="{http://maps.trimet.org/maps/model/xml}ItineraryType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ItinerariesType implements Parcelable {

    protected List<ItineraryType> itinerary;
    protected Integer count;

    /**
     * Gets the value of the itinerary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itinerary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItinerary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItineraryType }
     * 
     * 
     */
    public List<ItineraryType> getItinerary() {
        if (itinerary == null) {
            itinerary = new ArrayList<ItineraryType>();
        }
        return this.itinerary;
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
		dest.writeTypedList(itinerary);
	    dest.writeInt      (count    );
	}

	public static final Parcelable.Creator<ItinerariesType> CREATOR = new Parcelable.Creator<ItinerariesType>() {
		public ItinerariesType createFromParcel(Parcel in) {
			return new ItinerariesType(in);
		}

		public ItinerariesType[] newArray(int size) {
			return new ItinerariesType[size];
		}
	};
	
	private ItinerariesType(Parcel dest) {
		dest.readTypedList(itinerary, ItineraryType.CREATOR);
	    count = dest.readInt();
	}
}
