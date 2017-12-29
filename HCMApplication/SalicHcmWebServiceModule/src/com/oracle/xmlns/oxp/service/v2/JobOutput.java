
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JobOutput complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="burstKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="documentDataAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="documentDataCompressed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="documentDataContentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="outputId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="outputName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parentOutputId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
@XmlType(name = "JobOutput",
         propOrder =
         { "burstKey", "created", "deleted", "documentDataAvailable", "documentDataCompressed",
           "documentDataContentType", "jobId", "jobName", "lastUpdated", "outputId", "outputName", "parentOutputId",
           "status", "statusDetail"
    })
public class JobOutput {

    @XmlElement(required = true, nillable = true)
    protected String burstKey;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    protected boolean deleted;
    protected boolean documentDataAvailable;
    protected boolean documentDataCompressed;
    @XmlElement(required = true, nillable = true)
    protected String documentDataContentType;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long jobId;
    @XmlElement(required = true, nillable = true)
    protected String jobName;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long outputId;
    @XmlElement(required = true, nillable = true)
    protected String outputName;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long parentOutputId;
    @XmlElement(required = true, nillable = true)
    protected String status;
    @XmlElement(required = true, nillable = true)
    protected String statusDetail;

    /**
     * Gets the value of the burstKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBurstKey() {
        return burstKey;
    }

    /**
     * Sets the value of the burstKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBurstKey(String value) {
        this.burstKey = value;
    }

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
     * Gets the value of the deleted property.
     *
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     *
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the documentDataAvailable property.
     *
     */
    public boolean isDocumentDataAvailable() {
        return documentDataAvailable;
    }

    /**
     * Sets the value of the documentDataAvailable property.
     *
     */
    public void setDocumentDataAvailable(boolean value) {
        this.documentDataAvailable = value;
    }

    /**
     * Gets the value of the documentDataCompressed property.
     *
     */
    public boolean isDocumentDataCompressed() {
        return documentDataCompressed;
    }

    /**
     * Sets the value of the documentDataCompressed property.
     *
     */
    public void setDocumentDataCompressed(boolean value) {
        this.documentDataCompressed = value;
    }

    /**
     * Gets the value of the documentDataContentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDocumentDataContentType() {
        return documentDataContentType;
    }

    /**
     * Sets the value of the documentDataContentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDocumentDataContentType(String value) {
        this.documentDataContentType = value;
    }

    /**
     * Gets the value of the jobId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * Sets the value of the jobId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setJobId(Long value) {
        this.jobId = value;
    }

    /**
     * Gets the value of the jobName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the value of the jobName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobName(String value) {
        this.jobName = value;
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
     * Gets the value of the outputId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getOutputId() {
        return outputId;
    }

    /**
     * Sets the value of the outputId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setOutputId(Long value) {
        this.outputId = value;
    }

    /**
     * Gets the value of the outputName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutputName() {
        return outputName;
    }

    /**
     * Sets the value of the outputName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutputName(String value) {
        this.outputName = value;
    }

    /**
     * Gets the value of the parentOutputId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getParentOutputId() {
        return parentOutputId;
    }

    /**
     * Sets the value of the parentOutputId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setParentOutputId(Long value) {
        this.parentOutputId = value;
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
