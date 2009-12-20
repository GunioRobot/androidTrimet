package com.fixedd.AndroidTrimet.schemas.TypeDefs;

import java.util.ArrayList;
import java.util.List;


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
public class StopPointType extends PointType {

    protected String stopId;
    protected String streetPosition;
    protected String fareZone;
    protected int stopSequence;
    protected double distance;
    protected List<String> comment;

    /**
     * Gets the value of the stopId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopId() {
        return stopId;
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
        this.stopId = value;
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
        return streetPosition;
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
        this.streetPosition = value;
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
        return fareZone;
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
        this.fareZone = value;
    }

    /**
     * Gets the value of the stopSequence property.
     * 
     */
    public int getStopSequence() {
        return stopSequence;
    }

    /**
     * Sets the value of the stopSequence property.
     * 
     */
    public void setStopSequence(int value) {
        this.stopSequence = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(double value) {
        this.distance = value;
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
    public List<String> getComment() {
        if (comment == null) {
            comment = new ArrayList<String>();
        }
        return this.comment;
    }

}
