package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for arrivalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arrivalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blockPosition" type="{urn:trimet:arrivals}blockPositionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="locid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dir" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="shortSign" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fullSign" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="estimated" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="scheduled" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="block" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="piece" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="departed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="detour" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ArrivalType implements Parcelable {

    protected List<BlockPositionType> blockPosition;
    protected int route;
    protected int locid;
    protected int dir;
    protected String shortSign;
    protected String fullSign;
    protected Long estimated;
    protected long scheduled;
    protected int block;
    protected String piece;
    protected boolean departed;
    protected Boolean detour;
    protected String status;

    /**
     * Gets the value of the blockPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlockPositionType }
     * 
     * 
     */
    public List<BlockPositionType> getBlockPosition() {
        if (blockPosition == null) {
            blockPosition = new ArrayList<BlockPositionType>();
        }
        return this.blockPosition;
    }

    /**
     * Gets the value of the route property.
     * 
     */
    public int getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     */
    public void setRoute(int value) {
        this.route = value;
    }

    /**
     * Gets the value of the locid property.
     * 
     */
    public int getLocid() {
        return locid;
    }

    /**
     * Sets the value of the locid property.
     * 
     */
    public void setLocid(int value) {
        this.locid = value;
    }

    /**
     * Gets the value of the dir property.
     * 
     */
    public int getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     */
    public void setDir(int value) {
        this.dir = value;
    }

    /**
     * Gets the value of the shortSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortSign() {
        return shortSign;
    }

    /**
     * Sets the value of the shortSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortSign(String value) {
        this.shortSign = value;
    }

    /**
     * Gets the value of the fullSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullSign() {
        return fullSign;
    }

    /**
     * Sets the value of the fullSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullSign(String value) {
        this.fullSign = value;
    }

    /**
     * Gets the value of the estimated property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEstimated() {
        return estimated;
    }

    /**
     * Sets the value of the estimated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEstimated(Long value) {
        this.estimated = value;
    }

    /**
     * Gets the value of the scheduled property.
     * 
     */
    public long getScheduled() {
        return scheduled;
    }

    /**
     * Sets the value of the scheduled property.
     * 
     */
    public void setScheduled(long value) {
        this.scheduled = value;
    }

    /**
     * Gets the value of the block property.
     * 
     */
    public int getBlock() {
        return block;
    }

    /**
     * Sets the value of the block property.
     * 
     */
    public void setBlock(int value) {
        this.block = value;
    }

    /**
     * Gets the value of the piece property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPiece() {
        return piece;
    }

    /**
     * Sets the value of the piece property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPiece(String value) {
        this.piece = value;
    }

    /**
     * Gets the value of the departed property.
     * 
     */
    public boolean isDeparted() {
        return departed;
    }

    /**
     * Sets the value of the departed property.
     * 
     */
    public void setDeparted(boolean value) {
        this.departed = value;
    }

    /**
     * Gets the value of the detour property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDetour() {
        return detour;
    }

    /**
     * Sets the value of the detour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDetour(Boolean value) {
        this.detour = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
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
		dest.writeTypedList(blockPosition);
	    dest.writeInt   (route    );
	    dest.writeInt   (locid    );
	    dest.writeInt   (dir      );
	    dest.writeString(shortSign);
	    dest.writeString(fullSign );
	    dest.writeLong  (estimated);
	    dest.writeLong  (scheduled);
	    dest.writeInt   (block    );
	    dest.writeString(piece    );
	    dest.writeString(Boolean.toString(departed));
	    dest.writeString(Boolean.toString(detour  ));
	    dest.writeString(status   );
	}

	public static final Parcelable.Creator<ArrivalType> CREATOR = new Parcelable.Creator<ArrivalType>() {
		public ArrivalType createFromParcel(Parcel in) {
			return new ArrivalType(in);
		}

		public ArrivalType[] newArray(int size) {
			return new ArrivalType[size];
		}
	};
	
	private ArrivalType(Parcel dest) {
		dest.readTypedList(blockPosition, BlockPositionType.CREATOR);
		route     = dest.readInt();
	    locid     = dest.readInt();
	    dir       = dest.readInt();
	    shortSign = dest.readString();
	    fullSign  = dest.readString();
	    estimated = dest.readLong();
	    scheduled = dest.readLong();
	    block     = dest.readInt();
	    piece     = dest.readString();
	    departed  = Boolean.parseBoolean(dest.readString());
	    detour    = Boolean.parseBoolean(dest.readString());
	    status    = dest.readString();
	}
}
