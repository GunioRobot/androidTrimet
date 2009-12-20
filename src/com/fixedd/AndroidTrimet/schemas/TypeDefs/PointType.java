package com.fixedd.AndroidTrimet.schemas.TypeDefs;

/**
 * <p>Java class for PointType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pos" type="{http://maps.trimet.org/maps/model/xml}GeoPointType"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="areaKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="areaValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class PointType {

    protected GeoPointType pos;
    protected String description;
    protected String areaKey;
    protected String areaValue;
    protected String id;

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link GeoPointType }
     *     
     */
    public GeoPointType getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoPointType }
     *     
     */
    public void setPos(GeoPointType value) {
        this.pos = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the areaKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaKey() {
        return areaKey;
    }

    /**
     * Sets the value of the areaKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaKey(String value) {
        this.areaKey = value;
    }

    /**
     * Gets the value of the areaValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaValue() {
        return areaValue;
    }

    /**
     * Sets the value of the areaValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaValue(String value) {
        this.areaValue = value;
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
        return id;
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
        this.id = value;
    }

}
