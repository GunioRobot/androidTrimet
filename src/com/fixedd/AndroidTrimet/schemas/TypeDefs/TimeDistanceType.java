package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <p>Java class for TimeDistanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeDistanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="numberOfTransfers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfTripLegs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="walkingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transitTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waitingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class TimeDistanceType implements Parcelable {

	protected String	mDate				= "";
	protected String	mStartTime			= "";
	protected String	mEndTime			= "";
	protected int		mDuration			= -2147483648;
	protected double	mDistance			= -2147483648;
	protected int		mNumberOfTransfers	= -2147483648;
	protected int		mNumberOfTripLegs	= -2147483648;
	protected int		mWalkingTime		= -2147483648;
	protected int		mTransitTime		= -2147483648;
	protected int		mWaitingTime		= -2147483648;

	/**
	 * Create a new, empty copy of this object.
	 */
	public TimeDistanceType() {}

	/**
	 * Gets the value of the date property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getDate() {
		return mDate;
	}

	/**
	 * Sets the value of the date property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setDate(String value) {
		mDate = value;
	}

	/**
	 * Gets the value of the startTime property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getStartTime() {
		return mStartTime;
	}

	/**
	 * Sets the value of the startTime property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setStartTime(String value) {
		mStartTime = value;
	}

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getEndTime() {
		return mEndTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setEndTime(String value) {
		mEndTime = value;
	}

	/**
	 * Gets the value of the duration property.
	 * 
	 */
	public int getDuration() {
		return mDuration;
	}

	/**
	 * Sets the value of the duration property.
	 * 
	 */
	public void setDuration(int value) {
		mDuration = value;
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
	 * Gets the value of the numberOfTransfers property.
	 * 
	 */
	public int getNumberOfTransfers() {
		return mNumberOfTransfers;
	}

	/**
	 * Sets the value of the numberOfTransfers property.
	 * 
	 */
	public void setNumberOfTransfers(int value) {
		mNumberOfTransfers = value;
	}

	/**
	 * Gets the value of the numberOfTripLegs property.
	 * 
	 */
	public int getNumberOfTripLegs() {
		return mNumberOfTripLegs;
	}

	/**
	 * Sets the value of the numberOfTripLegs property.
	 * 
	 */
	public void setNumberOfTripLegs(int value) {
		mNumberOfTripLegs = value;
	}

	/**
	 * Gets the value of the walkingTime property.
	 * 
	 */
	public int getWalkingTime() {
		return mWalkingTime;
	}

	/**
	 * Sets the value of the walkingTime property.
	 * 
	 */
	public void setWalkingTime(int value) {
		mWalkingTime = value;
	}

	/**
	 * Gets the value of the transitTime property.
	 * 
	 */
	public int getTransitTime() {
		return mTransitTime;
	}

	/**
	 * Sets the value of the transitTime property.
	 * 
	 */
	public void setTransitTime(int value) {
		mTransitTime = value;
	}

	/**
	 * Gets the value of the waitingTime property.
	 * 
	 */
	public int getWaitingTime() {
		return mWaitingTime;
	}

	/**
	 * Sets the value of the waitingTime property.
	 * 
	 */
	public void setWaitingTime(int value) {
		mWaitingTime = value;
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
		dest.writeString(mDate             );
		dest.writeString(mStartTime        );
		dest.writeString(mEndTime          );
		dest.writeInt   (mDuration         );
		dest.writeDouble(mDistance         );
		dest.writeInt   (mNumberOfTransfers);
		dest.writeInt   (mNumberOfTripLegs );
		dest.writeInt   (mWalkingTime      );
		dest.writeInt   (mTransitTime      );
		dest.writeInt   (mWaitingTime      );
	}

	public static final Parcelable.Creator<TimeDistanceType> CREATOR = new Parcelable.Creator<TimeDistanceType>() {
		public TimeDistanceType createFromParcel(Parcel in) {
			return new TimeDistanceType(in);
		}

		public TimeDistanceType[] newArray(int size) {
			return new TimeDistanceType[size];
		}
	};

	private TimeDistanceType(Parcel dest) {
		mDate              = dest.readString();
		mStartTime         = dest.readString();
		mEndTime           = dest.readString();
		mDuration          = dest.readInt();
		mDistance          = dest.readDouble();
		mNumberOfTransfers = dest.readInt();
		mNumberOfTripLegs  = dest.readInt();
		mWalkingTime       = dest.readInt();
		mTransitTime       = dest.readInt();
		mWaitingTime       = dest.readInt();
	}
}
