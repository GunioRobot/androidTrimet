package com.fixedd.AndroidTrimet.schemas.Schedule;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for routeDirectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeDirectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stop" type="{urn:trimet:schedule}stopType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dir" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="desc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class RouteDirectionType {

    protected List<StopType> stop;
    protected int dir;
    protected String desc;

    /**
     * Gets the value of the stop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StopType }
     * 
     * 
     */
    public List<StopType> getStop() {
        if (stop == null) {
            stop = new ArrayList<StopType>();
        }
        return this.stop;
    }

    /**
     * Gets the value of the dir property.
     * 
     */
    public int getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     */
    public void setDir(int value) {
        this.dir = value;
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

}
