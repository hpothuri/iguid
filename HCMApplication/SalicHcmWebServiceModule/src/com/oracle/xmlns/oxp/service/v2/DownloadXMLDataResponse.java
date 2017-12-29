
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="downloadXMLDataReturn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "downloadXMLDataReturn" })
@XmlRootElement(name = "downloadXMLDataResponse")
public class DownloadXMLDataResponse {

    @XmlElement(required = true)
    protected String downloadXMLDataReturn;

    /**
     * Gets the value of the downloadXMLDataReturn property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDownloadXMLDataReturn() {
        return downloadXMLDataReturn;
    }

    /**
     * Sets the value of the downloadXMLDataReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDownloadXMLDataReturn(String value) {
        this.downloadXMLDataReturn = value;
    }

}
