package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for OrderedStringsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderedStringsType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class OrderedStringsType implements Parcelable {

	protected String	mValue	= "";
	protected int		mId		= -2147483648;

	/**
	 * Create a new, empty copy of this object.
	 */
	public OrderedStringsType() {}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getValue() {
		return mValue;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setValue(String value) {
		mValue = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public int getId() {
		return mId;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(int value) {
		mId = value;
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
		dest.writeString(mValue);
		dest.writeInt   (mId   );
	}

	public static final Parcelable.Creator<OrderedStringsType> CREATOR = new Parcelable.Creator<OrderedStringsType>() {
		public OrderedStringsType createFromParcel(Parcel in) {
			return new OrderedStringsType(in);
		}

		public OrderedStringsType[] newArray(int size) {
			return new OrderedStringsType[size];
		}
	};

	private OrderedStringsType(Parcel dest) {
		mValue = dest.readString();
		mId    = dest.readInt   ();
	}
}
