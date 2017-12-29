
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JobOutputDelivery complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobOutputDelivery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="deliveryID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="deliveryParameters" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="lastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="outputID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="parentDeliveryID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="statusDetail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobOutputDelivery",
         propOrder =
         { "created", "deliveryID", "deliveryParameters", "lastUpdated", "outputID", "parentDeliveryID", "status",
           "statusDetail"
    })
public class JobOutputDelivery {

    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long deliveryID;
    @XmlElement(required = true, nillable = true)
    protected byte[] deliveryParameters;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long outputID;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long parentDeliveryID;
    @XmlElement(required = true, nillable = true)
    protected String status;
    @XmlElement(required = true, nillable = true)
    protected String statusDetail;

    /**
     * Gets the value of the created property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the deliveryID property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getDeliveryID() {
        return deliveryID;
    }

    /**
     * Sets the value of the deliveryID property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setDeliveryID(Long value) {
        this.deliveryID = value;
    }

    /**
     * Gets the value of the deliveryParameters property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDeliveryParameters() {
        return deliveryParameters;
    }

    /**
     * Sets the value of the deliveryParameters property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDeliveryParameters(byte[] value) {
        this.deliveryParameters = value;
    }

    /**
     * Gets the value of the lastUpdated property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the value of the lastUpdated property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setLastUpdated(XMLGregorianCalendar value) {
        this.lastUpdated = value;
    }

    /**
     * Gets the value of the outputID property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getOutputID() {
        return outputID;
    }

    /**
     * Sets the value of the outputID property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setOutputID(Long value) {
        this.outputID = value;
    }

    /**
     * Gets the value of the parentDeliveryID property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getParentDeliveryID() {
        return parentDeliveryID;
    }

    /**
     * Sets the value of the parentDeliveryID property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setParentDeliveryID(Long value) {
        this.parentDeliveryID = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusDetail property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatusDetail() {
        return statusDetail;
    }

    /**
     * Sets the value of the statusDetail property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatusDetail(String value) {
        this.statusDetail = value;
    }

}
