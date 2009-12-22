package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for detourType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detourType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="route" type="{urn:trimet:schedule}routeType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="begin" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="end" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="phonetic" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DetourType implements Parcelable {

    protected List<RouteType> route;
    protected long begin;
    protected long end;
    protected String id;
    protected String desc;
    protected String phonetic;

    public DetourType() {}
    
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
     * Gets the value of the begin property.
     * 
     */
    public long getBegin() {
        return begin;
    }

    /**
     * Sets the value of the begin property.
     * 
     */
    public void setBegin(long value) {
        this.begin = value;
    }

    /**
     * Gets the value of the end property.
     * 
     */
    public long getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     */
    public void setEnd(long value) {
        this.end = value;
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
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the phonetic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhonetic() {
        return phonetic;
    }

    /**
     * Sets the value of the phonetic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhonetic(String value) {
        this.phonetic = value;
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
		dest.writeTypedList(route);
	    dest.writeLong  (begin   );
	    dest.writeLong  (end     );
	    dest.writeString(id      );
	    dest.writeString(desc    );
	    dest.writeString(phonetic);
	}

	public static final Parcelable.Creator<DetourType> CREATOR = new Parcelable.Creator<DetourType>() {
		public DetourType createFromParcel(Parcel in) {
			return new DetourType(in);
		}

		public DetourType[] newArray(int size) {
			return new DetourType[size];
		}
	};
	
	private DetourType(Parcel dest) {
		dest.readTypedList(route, RouteType.CREATOR);
	    begin    = dest.readLong  ();
	    end      = dest.readLong  ();
	    id       = dest.readString();
	    desc     = dest.readString();
	    phonetic = dest.readString();
	}
}
