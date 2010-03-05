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

	protected String					mStopId			= "";
	protected String					mStreetPosition	= "";
	protected String					mFareZone		= "";
	protected int						mStopSequence	= -2147483648;
	protected double					mDistance		= -2147483648;
	protected List<ParcelableString>	mComment;

	/**
	 * Create a new, empty copy of this object.
	 */
	public StopPointType() {}

	/**
	 * Gets the value of the stopId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getStopId() {
		return mStopId;
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
		mStopId = value;
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
		return mStreetPosition;
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
		mStreetPosition = value;
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
		return mFareZone;
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
		mFareZone = value;
	}

	/**
	 * Gets the value of the stopSequence property.
	 * 
	 */
	public int getStopSequence() {
		return mStopSequence;
	}

	/**
	 * Sets the value of the stopSequence property.
	 * 
	 */
	public void setStopSequence(int value) {
		mStopSequence = value;
	}

	/**
	 * Gets the value of the distance property.
	 * 
	 */
	public double getDistance() {
		return mDistance;
	}

	/**
	 * Sets the value of the distance property.
	 * 
	 */
	public void setDistance(double value) {
		mDistance = value;
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
		if (mComment == null) {
			mComment = new ArrayList<ParcelableString>();
		}
		return mComment;
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
		// from PointType
		if (mPos != null) {
			dest.writeInt(1);
			dest.writeParcelable(mPos, flags);
		} else
			dest.writeInt(0);
		dest.writeString(mDescription);
		dest.writeString(mAreaKey    );
		dest.writeString(mAreaValue  );
		dest.writeString(mId         );
		
		// from StopPointType
		dest.writeString(mStopId        );
		dest.writeString(mStreetPosition);
		dest.writeString(mFareZone      );
		dest.writeInt   (mStopSequence  );
		dest.writeDouble(mDistance      );
		if (mComment != null && mComment.size() > 0) {
			dest.writeInt(1);
			dest.writeTypedList(mComment);
		} else
			dest.writeInt(0);
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
		// from PointType
		if (dest.readInt() == 1) mPos = (GeoPointType) dest.readParcelable(getClass().getClassLoader());
		mDescription = dest.readString();
		mAreaKey     = dest.readString();
		mAreaValue   = dest.readString();
		mId          = dest.readString();
		
		// from StopPointType
		mStopId         = dest.readString();
		mStreetPosition = dest.readString();
		mFareZone       = dest.readString();
		mStopSequence   = dest.readInt   ();
		mDistance       = dest.readDouble();
		if (dest.readInt() == 1) {
			mComment = new ArrayList<ParcelableString>();
			dest.readTypedList(mComment, ParcelableString.CREATOR);
		}
	}
}
