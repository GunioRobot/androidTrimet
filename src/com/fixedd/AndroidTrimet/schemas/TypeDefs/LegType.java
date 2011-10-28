package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import android.os.Parcelable;

/**
 * <p>Java class for LegType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LegType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time-distance" type="{http://maps.trimet.org/maps/model/xml}TimeDistanceType"/>
 *         &lt;element name="lineURL" type="{http://maps.trimet.org/maps/model/xml}GeoURLType" minOccurs="0"/>
 *         &lt;element name="from" type="{http://maps.trimet.org/maps/model/xml}PointType"/>
 *         &lt;element name="to" type="{http://maps.trimet.org/maps/model/xml}PointType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mode" type="{http://maps.trimet.org/maps/model/xml}ModeType" />
 *       &lt;attribute name="order" type="{http://maps.trimet.org/maps/model/xml}OrderType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
public abstract class LegType implements Parcelable {

	protected TimeDistanceType	mTimeDistance;
	protected GeoURLType		mLineURL;
	protected PointType			mFrom;
	protected PointType			mTo;
	protected String			mId		= "";
	protected String			mMode	= "";
	protected OrderType			mOrder;

	/**
	 * Gets the value of the timeDistance property.
	 *
	 * @return
	 *     possible object is
	 *     {@link TimeDistanceType }
	 *
	 */
	public TimeDistanceType getTimeDistance() {
		return mTimeDistance;
	}

	/**
	 * Sets the value of the timeDistance property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link TimeDistanceType }
	 *
	 */
	public void setTimeDistance(TimeDistanceType value) {
		mTimeDistance = value;
	}

	/**
	 * Gets the value of the lineURL property.
	 *
	 * @return
	 *     possible object is
	 *     {@link GeoURLType }
	 *
	 */
	public GeoURLType getLineURL() {
		return mLineURL;
	}

	/**
	 * Sets the value of the lineURL property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link GeoURLType }
	 *
	 */
	public void setLineURL(GeoURLType value) {
		mLineURL = value;
	}

	/**
	 * Gets the value of the from property.
	 *
	 * @return
	 *     possible object is
	 *     {@link PointType }
	 *
	 */
	public PointType getFrom() {
		return mFrom;
	}

	/**
	 * Sets the value of the from property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link PointType }
	 *
	 */
	public void setFrom(PointType value) {
		mFrom = value;
	}

	/**
	 * Gets the value of the to property.
	 *
	 * @return
	 *     possible object is
	 *     {@link PointType }
	 *
	 */
	public PointType getTo() {
		return mTo;
	}

	/**
	 * Sets the value of the to property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link PointType }
	 *
	 */
	public void setTo(PointType value) {
		mTo = value;
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
		return mId;
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
		mId = value;
	}

	/**
	 * Gets the value of the mode property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getMode() {
		return mMode;
	}

	/**
	 * Sets the value of the mode property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setMode(String value) {
		mMode = value;
	}

	/**
	 * Gets the value of the order property.
	 *
	 * @return
	 *     possible object is
	 *     {@link OrderType }
	 *
	 */
	public OrderType getOrder() {
		return mOrder;
	}

	/**
	 * Sets the value of the order property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link OrderType }
	 *
	 */
	public void setOrder(OrderType value) {
		mOrder = value;
	}


	// this is for Parcelable. It (FOR SERIOUSLY!!!) must be reassigned to something meaningful by subclasses.
	public static Parcelable.Creator<LegType> CREATOR;
}
