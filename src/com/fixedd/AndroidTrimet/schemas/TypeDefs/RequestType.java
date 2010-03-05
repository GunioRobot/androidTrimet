package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for RequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RequestType implements Parcelable {

	protected String		mUrl	= "";
	protected List<Param>	mParam;

	/**
	 * Create a new, empty copy of this object.
	 */
	public RequestType() {}

	/**
	 * Gets the value of the url property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getUrl() {
		return mUrl;
	}

	/**
	 * Sets the value of the url property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setUrl(String value) {
		mUrl = value;
	}

	/**
	 * Gets the value of the param property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the param property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getParam().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RequestType.Param }
	 * 
	 * 
	 */
	public List<RequestType.Param> getParam() {
		if (mParam == null) {
			mParam = new ArrayList<Param>();
		}
		return mParam;
	}


	/**
	 * <p>Java class for anonymous complex type.
	 * 
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;simpleContent>
	 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *     &lt;/extension>
	 *   &lt;/simpleContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	public static class Param implements Parcelable {

		protected String	mValue	= "";
		protected String	mName	= "";

		public Param() {}

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
			dest.writeString(mName);
		}

		public static final Parcelable.Creator<Param> CREATOR = new Parcelable.Creator<Param>() {
			public Param createFromParcel(Parcel in) {
				return new Param(in);
			}

			public Param[] newArray(int size) {
				return new Param[size];
			}
		};

		private Param(Parcel dest) {
			mValue = dest.readString();
			mName  = dest.readString();
		}
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
		dest.writeString(mUrl);
		if (mParam != null && mParam.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mParam);
		} else
			dest.writeInt(0);
	}

	public static final Parcelable.Creator<RequestType> CREATOR = new Parcelable.Creator<RequestType>() {
		public RequestType createFromParcel(Parcel in) {
			return new RequestType(in);
		}

		public RequestType[] newArray(int size) {
			return new RequestType[size];
		}
	};

	private RequestType(Parcel dest) {
		mUrl = dest.readString();
		if (dest.readInt() == 1) {
			mParam = new ArrayList<Param>();
			dest.readTypedList(mParam, Param.CREATOR);
		}
	}
}
