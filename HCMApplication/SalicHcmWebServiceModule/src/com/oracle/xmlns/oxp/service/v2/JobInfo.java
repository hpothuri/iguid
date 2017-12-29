
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JobInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="burstingJob" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="jobType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parentJobId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="public" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="reportUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="statusDetail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userJobName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobInfo",
         propOrder =
         { "burstingJob", "created", "deleted", "endDate", "instanceId", "jobId", "jobType", "lastUpdated", "owner",
           "parentJobId", "_public", "reportUrl", "startDate", "status", "statusDetail", "userJobName"
    })
public class JobInfo {

    protected boolean burstingJob;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    protected boolean deleted;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long instanceId;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long jobId;
    @XmlElement(required = true, nillable = true)
    protected String jobType;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    @XmlElement(required = true, nillable = true)
    protected String owner;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long parentJobId;
    @XmlElement(name = "public")
    protected boolean _public;
    @XmlElement(required = true, nillable = true)
    protected String reportUrl;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(required = true, nillable = true)
    protected String status;
    @XmlElement(required = true, nillable = true)
    protected String statusDetail;
    @XmlElement(required = true, nillable = true)
    protected String userJobName;

    /**
     * Gets the value of the burstingJob property.
     *
     */
    public boolean isBurstingJob() {
        return burstingJob;
    }

    /**
     * Sets the value of the burstingJob property.
     *
     */
    public void setBurstingJob(boolean value) {
        this.burstingJob = value;
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
     * Gets the value of the endDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the instanceId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setInstanceId(Long value) {
        this.instanceId = value;
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
     * Gets the value of the jobType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * Sets the value of the jobType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobType(String value) {
        this.jobType = value;
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
     * Gets the value of the parentJobId property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getParentJobId() {
        return parentJobId;
    }

    /**
     * Sets the value of the parentJobId property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setParentJobId(Long value) {
        this.parentJobId = value;
    }

    /**
     * Gets the value of the public property.
     *
     */
    public boolean isPublic() {
        return _public;
    }

    /**
     * Sets the value of the public property.
     *
     */
    public void setPublic(boolean value) {
        this._public = value;
    }

    /**
     * Gets the value of the reportUrl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportUrl() {
        return reportUrl;
    }

    /**
     * Sets the value of the reportUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportUrl(String value) {
        this.reportUrl = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
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

    /**
     * Gets the value of the userJobName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserJobName() {
        return userJobName;
    }

    /**
     * Sets the value of the userJobName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserJobName(String value) {
        this.userJobName = value;
    }

}
