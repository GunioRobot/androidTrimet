package com.fixedd.AndroidTrimet.schemas.Schedule;

/**
 * <p>Java class for stopType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stopType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="locid" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="lat" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="lng" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="seq" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="tp" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class StopType {

    protected String desc;
    protected int locid;
    protected double lat;
    protected double lng;
    protected int seq;
    protected boolean tp;

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the locid property.
     * 
     */
    public int getLocid() {
        return locid;
    }

    /**
     * Sets the value of the locid property.
     * 
     */
    public void setLocid(int value) {
        this.locid = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lng property.
     * 
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the value of the lng property.
     * 
     */
    public void setLng(double value) {
        this.lng = value;
    }

    /**
     * Gets the value of the seq property.
     * 
     */
    public int getSeq() {
        return seq;
    }

    /**
     * Sets the value of the seq property.
     * 
     */
    public void setSeq(int value) {
        this.seq = value;
    }

    /**
     * Gets the value of the tp property.
     * 
     */
    public boolean isTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     */
    public void setTp(boolean value) {
        this.tp = value;
    }

}
