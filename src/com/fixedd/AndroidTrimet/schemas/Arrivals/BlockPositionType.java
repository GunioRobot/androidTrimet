package com.fixedd.AndroidTrimet.schemas.Arrivals;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for blockPositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="blockPositionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trip" type="{urn:trimet:arrivals}tripType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="layover" type="{urn:trimet:arrivals}layoverType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="at" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="lat" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="lng" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="heading" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="feet" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class BlockPositionType {

    protected List<TripType> trip;
    protected List<LayoverType> layover;
    protected long at;
    protected Double lat;
    protected Double lng;
    protected Integer heading;
    protected int feet;

    /**
     * Gets the value of the trip property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trip property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrip().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TripType }
     * 
     * 
     */
    public List<TripType> getTrip() {
        if (trip == null) {
            trip = new ArrayList<TripType>();
        }
        return this.trip;
    }

    /**
     * Gets the value of the layover property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the layover property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLayover().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LayoverType }
     * 
     * 
     */
    public List<LayoverType> getLayover() {
        if (layover == null) {
            layover = new ArrayList<LayoverType>();
        }
        return this.layover;
    }

    /**
     * Gets the value of the at property.
     * 
     */
    public long getAt() {
        return at;
    }

    /**
     * Sets the value of the at property.
     * 
     */
    public void setAt(long value) {
        this.at = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLat(Double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lng property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLng() {
        return lng;
    }

    /**
     * Sets the value of the lng property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLng(Double value) {
        this.lng = value;
    }

    /**
     * Gets the value of the heading property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHeading() {
        return heading;
    }

    /**
     * Sets the value of the heading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHeading(Integer value) {
        this.heading = value;
    }

    /**
     * Gets the value of the feet property.
     * 
     */
    public int getFeet() {
        return feet;
    }

    /**
     * Sets the value of the feet property.
     * 
     */
    public void setFeet(int value) {
        this.feet = value;
    }

}
