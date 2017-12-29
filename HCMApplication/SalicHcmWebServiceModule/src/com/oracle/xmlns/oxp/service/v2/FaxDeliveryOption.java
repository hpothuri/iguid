
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxDeliveryOption complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FaxDeliveryOption"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="faxServer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxDeliveryOption", propOrder = { "faxNumber", "faxServer" })
public class FaxDeliveryOption {

    @XmlElement(required = true, nillable = true)
    protected String faxNumber;
    @XmlElement(required = true, nillable = true)
    protected String faxServer;

    /**
     * Gets the value of the faxNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the faxServer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFaxServer() {
        return faxServer;
    }

    /**
     * Sets the value of the faxServer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFaxServer(String value) {
        this.faxServer = value;
    }

}
