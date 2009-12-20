package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for routeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dir" type="{urn:trimet:schedule}routeDirectionType" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="detour" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteType {

    protected List<RouteDirectionType> dir;
    protected int route;
    protected String desc;
    protected Boolean detour;
    protected String type;

    /**
     * Gets the value of the dir property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dir property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDir().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteDirectionType }
     * 
     * 
     */
    public List<RouteDirectionType> getDir() {
        if (dir == null) {
            dir = new ArrayList<RouteDirectionType>();
        }
        return this.dir;
    }

    /**
     * Gets the value of the route property.
     * 
     */
    public int getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     */
    public void setRoute(int value) {
        this.route = value;
    }

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
     * Gets the value of the detour property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDetour() {
        return detour;
    }

    /**
     * Sets the value of the detour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDetour(Boolean value) {
        this.detour = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
