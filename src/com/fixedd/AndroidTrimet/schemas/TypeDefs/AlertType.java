package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for AlertType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlertType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="begin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://maps.trimet.org/maps/model/xml}StatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
public class AlertType implements Parcelable {

	protected String		mDescription	= "";
	protected String		mBegin			= "";
	protected String		mEnd			= "";
	protected StatusType	mStatus;

	/**
	 * Create a new, empty copy of this object.
	 */
	public AlertType() {}

	/**
	 * Gets the value of the description property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getDescription() {
		return mDescription;
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
		mDescription = value;
	}

	/**
	 * Gets the value of the begin property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getBegin() {
		return mBegin;
	}

	/**
	 * Sets the value of the begin property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setBegin(String value) {
		mBegin = value;
	}

	/**
	 * Gets the value of the end property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getEnd() {
		return mEnd;
	}

	/**
	 * Sets the value of the end property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setEnd(String value) {
		mEnd = value;
	}

	/**
	 * Gets the value of the status property.
	 *
	 * @return
	 *     possible object is
	 *     {@link StatusType }
	 *
	 */
	public StatusType getStatus() {
		return mStatus;
	}

	/**
	 * Sets the value of the status property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link StatusType }
	 *
	 */
	public void setStatus(StatusType value) {
		mStatus = value;
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
		dest.writeString(mDescription   );
		dest.writeString(mBegin         );
		dest.writeString(mEnd           );
		dest.writeString(mStatus.value());
	}

	public static final Parcelable.Creator<AlertType> CREATOR = new Parcelable.Creator<AlertType>() {
		public AlertType createFromParcel(Parcel in) {
			return new AlertType(in);
		}

		public AlertType[] newArray(int size) {
			return new AlertType[size];
		}
	};

	private AlertType(Parcel dest) {
		mDescription = dest.readString();
		mBegin       = dest.readString();
		mEnd         = dest.readString();
		mStatus      = StatusType.fromValue(dest.readString());
	}
}
