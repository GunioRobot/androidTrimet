package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for ErrorType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ErrorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" type="{http://maps.trimet.org/maps/model/xml}ErrorCodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
public class ErrorType implements Parcelable {

	protected String	mMessage	= "";
	protected String	mCode		= "";

	/**
	 * Create a new, empty copy of this object.
	 */
	public ErrorType() {}

	/**
	 * Gets the value of the message property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getMessage() {
		return mMessage;
	}

	/**
	 * Sets the value of the message property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setMessage(String value) {
		mMessage = value;
	}

	/**
	 * Gets the value of the code property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getCode() {
		return mCode;
	}

	/**
	 * Sets the value of the code property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setCode(String value) {
		mCode = value;
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
		dest.writeString(mMessage);
		dest.writeString(mCode   );
	}

	public static final Parcelable.Creator<ErrorType> CREATOR = new Parcelable.Creator<ErrorType>() {
		public ErrorType createFromParcel(Parcel in) {
			return new ErrorType(in);
		}

		public ErrorType[] newArray(int size) {
			return new ErrorType[size];
		}
	};

	private ErrorType(Parcel dest) {
		mMessage = dest.readString();
		mCode    = dest.readString();
	}
}
