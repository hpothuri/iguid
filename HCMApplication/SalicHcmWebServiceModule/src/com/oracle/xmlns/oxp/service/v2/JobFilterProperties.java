
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobFilterProperties complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobFilterProperties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="endTimeOperator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobNameOperator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ownerOperator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reportNameOperator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scope" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startTimeOperator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobFilterProperties",
         propOrder =
         { "endTime", "endTimeOperator", "jobId", "jobName", "jobNameOperator", "owner", "ownerOperator", "reportName",
           "reportNameOperator", "scope", "startTime", "startTimeOperator", "status"
    })
public class JobFilterProperties {

    @XmlElement(required = true, nillable = true)
    protected String endTime;
    @XmlElement(required = true, nillable = true)
    protected String endTimeOperator;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long jobId;
    @XmlElement(required = true, nillable = true)
    protected String jobName;
    @XmlElement(required = true, nillable = true)
    protected String jobNameOperator;
    @XmlElement(required = true, nillable = true)
    protected String owner;
    @XmlElement(required = true, nillable = true)
    protected String ownerOperator;
    @XmlElement(required = true, nillable = true)
    protected String reportName;
    @XmlElement(required = true, nillable = true)
    protected String reportNameOperator;
    @XmlElement(required = true, nillable = true)
    protected String scope;
    @XmlElement(required = true, nillable = true)
    protected String startTime;
    @XmlElement(required = true, nillable = true)
    protected String startTimeOperator;
    @XmlElement(required = true, nillable = true)
    protected String status;

    /**
     * Gets the value of the endTime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the endTimeOperator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndTimeOperator() {
        return endTimeOperator;
    }

    /**
     * Sets the value of the endTimeOperator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndTimeOperator(String value) {
        this.endTimeOperator = value;
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
     * Gets the value of the jobNameOperator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobNameOperator() {
        return jobNameOperator;
    }

    /**
     * Sets the value of the jobNameOperator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobNameOperator(String value) {
        this.jobNameOperator = value;
    }

    /**
     * Gets the value of the owner property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the ownerOperator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOwnerOperator() {
        return ownerOperator;
    }

    /**
     * Sets the value of the ownerOperator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOwnerOperator(String value) {
        this.ownerOperator = value;
    }

    /**
     * Gets the value of the reportName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the reportNameOperator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportNameOperator() {
        return reportNameOperator;
    }

    /**
     * Sets the value of the reportNameOperator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportNameOperator(String value) {
        this.reportNameOperator = value;
    }

    /**
     * Gets the value of the scope property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the startTime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the startTimeOperator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartTimeOperator() {
        return startTimeOperator;
    }

    /**
     * Sets the value of the startTimeOperator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartTimeOperator(String value) {
        this.startTimeOperator = value;
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

}
