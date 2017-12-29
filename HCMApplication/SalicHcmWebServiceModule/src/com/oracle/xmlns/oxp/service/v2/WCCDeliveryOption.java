
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WCCDeliveryOption complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="WCCDeliveryOption"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WCCAccount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCAuthor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCComments" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCFileName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCIncludeMetadata" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="WCCSecurityGroup" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCServerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="WCCTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WCCDeliveryOption",
         propOrder =
         { "wccAccount", "wccAuthor", "wccComments", "wccFileName", "wccIncludeMetadata", "wccSecurityGroup",
           "wccServerName", "wccTitle"
    })
public class WCCDeliveryOption {

    @XmlElement(name = "WCCAccount", required = true, nillable = true)
    protected String wccAccount;
    @XmlElement(name = "WCCAuthor", required = true, nillable = true)
    protected String wccAuthor;
    @XmlElement(name = "WCCComments", required = true, nillable = true)
    protected String wccComments;
    @XmlElement(name = "WCCFileName", required = true, nillable = true)
    protected String wccFileName;
    @XmlElement(name = "WCCIncludeMetadata")
    protected boolean wccIncludeMetadata;
    @XmlElement(name = "WCCSecurityGroup", required = true, nillable = true)
    protected String wccSecurityGroup;
    @XmlElement(name = "WCCServerName", required = true, nillable = true)
    protected String wccServerName;
    @XmlElement(name = "WCCTitle", required = true, nillable = true)
    protected String wccTitle;

    /**
     * Gets the value of the wccAccount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCAccount() {
        return wccAccount;
    }

    /**
     * Sets the value of the wccAccount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCAccount(String value) {
        this.wccAccount = value;
    }

    /**
     * Gets the value of the wccAuthor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCAuthor() {
        return wccAuthor;
    }

    /**
     * Sets the value of the wccAuthor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCAuthor(String value) {
        this.wccAuthor = value;
    }

    /**
     * Gets the value of the wccComments property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCComments() {
        return wccComments;
    }

    /**
     * Sets the value of the wccComments property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCComments(String value) {
        this.wccComments = value;
    }

    /**
     * Gets the value of the wccFileName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCFileName() {
        return wccFileName;
    }

    /**
     * Sets the value of the wccFileName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCFileName(String value) {
        this.wccFileName = value;
    }

    /**
     * Gets the value of the wccIncludeMetadata property.
     *
     */
    public boolean isWCCIncludeMetadata() {
        return wccIncludeMetadata;
    }

    /**
     * Sets the value of the wccIncludeMetadata property.
     *
     */
    public void setWCCIncludeMetadata(boolean value) {
        this.wccIncludeMetadata = value;
    }

    /**
     * Gets the value of the wccSecurityGroup property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCSecurityGroup() {
        return wccSecurityGroup;
    }

    /**
     * Sets the value of the wccSecurityGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCSecurityGroup(String value) {
        this.wccSecurityGroup = value;
    }

    /**
     * Gets the value of the wccServerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCServerName() {
        return wccServerName;
    }

    /**
     * Sets the value of the wccServerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCServerName(String value) {
        this.wccServerName = value;
    }

    /**
     * Gets the value of the wccTitle property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWCCTitle() {
        return wccTitle;
    }

    /**
     * Sets the value of the wccTitle property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWCCTitle(String value) {
        this.wccTitle = value;
    }

}
