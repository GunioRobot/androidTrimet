package com.fixedd.AndroidTrimet.schemas.TypeDefs;

/**
 * <p>Java class for GeoRouteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoRouteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ogcFilter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfsUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wmsUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class GeoRouteType {

    protected String domain;
    protected String typeName;
    protected String ogcFilter;
    protected String wfsUrl;
    protected String wmsUrl;

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the ogcFilter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOgcFilter() {
        return ogcFilter;
    }

    /**
     * Sets the value of the ogcFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOgcFilter(String value) {
        this.ogcFilter = value;
    }

    /**
     * Gets the value of the wfsUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfsUrl() {
        return wfsUrl;
    }

    /**
     * Sets the value of the wfsUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfsUrl(String value) {
        this.wfsUrl = value;
    }

    /**
     * Gets the value of the wmsUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWmsUrl() {
        return wmsUrl;
    }

    /**
     * Sets the value of the wmsUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWmsUrl(String value) {
        this.wmsUrl = value;
    }

}
