
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
 *         &lt;element name="getDocumentDataReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getDocumentDataReturn" })
@XmlRootElement(name = "getDocumentDataResponse")
public class GetDocumentDataResponse {

    @XmlElement(required = true)
    protected byte[] getDocumentDataReturn;

    /**
     * Gets the value of the getDocumentDataReturn property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetDocumentDataReturn() {
        return getDocumentDataReturn;
    }

    /**
     * Sets the value of the getDocumentDataReturn property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetDocumentDataReturn(byte[] value) {
        this.getDocumentDataReturn = value;
    }

}
