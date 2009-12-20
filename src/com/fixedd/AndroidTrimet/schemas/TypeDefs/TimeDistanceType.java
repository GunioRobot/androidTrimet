package com.fixedd.AndroidTrimet.schemas.TypeDefs;

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
public class TimeDistanceType {

    protected String date;
    protected String startTime;
    protected String endTime;
    protected int duration;
    protected double distance;
    protected int numberOfTransfers;
    protected int numberOfTripLegs;
    protected int walkingTime;
    protected int transitTime;
    protected int waitingTime;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
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
        this.date = value;
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
        return startTime;
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
        this.startTime = value;
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
        return endTime;
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
        this.endTime = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
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
     * Gets the value of the numberOfTransfers property.
     * 
     */
    public int getNumberOfTransfers() {
        return numberOfTransfers;
    }

    /**
     * Sets the value of the numberOfTransfers property.
     * 
     */
    public void setNumberOfTransfers(int value) {
        this.numberOfTransfers = value;
    }

    /**
     * Gets the value of the numberOfTripLegs property.
     * 
     */
    public int getNumberOfTripLegs() {
        return numberOfTripLegs;
    }

    /**
     * Sets the value of the numberOfTripLegs property.
     * 
     */
    public void setNumberOfTripLegs(int value) {
        this.numberOfTripLegs = value;
    }

    /**
     * Gets the value of the walkingTime property.
     * 
     */
    public int getWalkingTime() {
        return walkingTime;
    }

    /**
     * Sets the value of the walkingTime property.
     * 
     */
    public void setWalkingTime(int value) {
        this.walkingTime = value;
    }

    /**
     * Gets the value of the transitTime property.
     * 
     */
    public int getTransitTime() {
        return transitTime;
    }

    /**
     * Sets the value of the transitTime property.
     * 
     */
    public void setTransitTime(int value) {
        this.transitTime = value;
    }

    /**
     * Gets the value of the waitingTime property.
     * 
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Sets the value of the waitingTime property.
     * 
     */
    public void setWaitingTime(int value) {
        this.waitingTime = value;
    }

}
