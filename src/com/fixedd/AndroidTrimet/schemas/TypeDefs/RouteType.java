package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for RouteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="internalNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direction" type="{http://maps.trimet.org/maps/model/xml}DirType"/>
 *         &lt;element name="block" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alert" type="{http://maps.trimet.org/maps/model/xml}AlertType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteType implements Parcelable {

	protected String			mNumber			= "";
	protected String			mInternalNumber	= "";
	protected String			mName			= "";
	protected String			mKey			= "";
	protected String			mDirection		= "";
	protected String			mBlock			= "";
	protected String			mProvider		= "";
	protected List<AlertType>	mAlert;

	/**
	 * Create a new, empty copy of this object.
	 */
	public RouteType() {}

	/**
	 * Gets the value of the number property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getNumber() {
		return mNumber;
	}

	/**
	 * Sets the value of the number property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setNumber(String value) {
		mNumber = value;
	}

	/**
	 * Gets the value of the internalNumber property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getInternalNumber() {
		return mInternalNumber;
	}

	/**
	 * Sets the value of the internalNumber property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setInternalNumber(String value) {
		mInternalNumber = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setName(String value) {
		mName = value;
	}

	/**
	 * Gets the value of the key property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getKey() {
		return mKey;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setKey(String value) {
		mKey = value;
	}

	/**
	 * Gets the value of the direction property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDirection() {
		return mDirection;
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
		mDirection = value;
	}

	/**
	 * Gets the value of the block property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getBlock() {
		return mBlock;
	}

	/**
	 * Sets the value of the block property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setBlock(String value) {
		mBlock = value;
	}

	/**
	 * Gets the value of the provider property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getProvider() {
		return mProvider;
	}

	/**
	 * Sets the value of the provider property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setProvider(String value) {
		mProvider = value;
	}

	/**
	 * Gets the value of the alert property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the alert property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getAlert().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link AlertType }
	 * 
	 * 
	 */
	public List<AlertType> getAlert() {
		if (mAlert == null) {
			mAlert = new ArrayList<AlertType>();
		}
		return mAlert;
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
		dest.writeString   (mNumber        );
		dest.writeString   (mInternalNumber);
		dest.writeString   (mName          );
		dest.writeString   (mKey           );
		dest.writeString   (mDirection     );
		dest.writeString   (mBlock         );
		dest.writeString   (mProvider      );
		if (mAlert != null && mAlert.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mAlert);
		} else
			dest.writeInt(0);
	}

	public static final Parcelable.Creator<RouteType> CREATOR = new Parcelable.Creator<RouteType>() {
		public RouteType createFromParcel(Parcel in) {
			return new RouteType(in);
		}

		public RouteType[] newArray(int size) {
			return new RouteType[size];
		}
	};

	private RouteType(Parcel dest) {
		mNumber         = dest.readString();
		mInternalNumber = dest.readString();
		mName           = dest.readString();
		mKey            = dest.readString();
		mDirection      = dest.readString();
		mBlock          = dest.readString();
		mProvider       = dest.readString();
		if (dest.readInt() == 1) dest.readTypedList(mAlert, AlertType.CREATOR);
	}
}
