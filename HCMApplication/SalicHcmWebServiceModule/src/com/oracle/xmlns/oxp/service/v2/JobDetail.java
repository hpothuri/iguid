
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JobDetail complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bursting" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="burstingParameters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="dataLocator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="deliveryDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deliveryParameters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="instanceId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="issuer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobGroup" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="jobSetId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="jobType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="lastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notificationParameters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="parentJobId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="public" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="reportParameters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reportUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="runType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scheduleContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scheduleDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scheduleParameters" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="scheduleSource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="statusDetail" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="storageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userJobName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="xmlDataAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="xmlDataCompressed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="xmlDataContentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="xschurl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobDetail",
         propOrder =
         { "bursting", "burstingParameters", "created", "dataLocator", "deleted", "deliveryDescription",
           "deliveryParameters", "endDate", "instanceId", "issuer", "jobGroup", "jobId", "jobSetId", "jobType",
           "lastUpdated", "locale", "notificationParameters", "owner", "parentJobId", "_public", "reportParameters",
           "reportUrl", "runType", "scheduleContext", "scheduleDescription", "scheduleParameters", "scheduleSource",
           "startDate", "status", "statusDetail", "storageType", "userDescription", "userJobName", "xmlDataAvailable",
           "xmlDataCompressed", "xmlDataContentType", "xschurl"
    })
public class JobDetail {

    protected boolean bursting;
    @XmlElement(required = true, nillable = true)
    protected String burstingParameters;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(required = true, nillable = true)
    protected String dataLocator;
    protected boolean deleted;
    @XmlElement(required = true, nillable = true)
    protected String deliveryDescription;
    @XmlElement(required = true, nillable = true)
    protected String deliveryParameters;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected int instanceId;
    @XmlElement(required = true, nillable = true)
    protected String issuer;
    @XmlElement(required = true, nillable = true)
    protected String jobGroup;
    protected int jobId;
    protected int jobSetId;
    @XmlElement(required = true, nillable = true)
    protected String jobType;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    @XmlElement(required = true, nillable = true)
    protected String locale;
    @XmlElement(required = true, nillable = true)
    protected String notificationParameters;
    @XmlElement(required = true, nillable = true)
    protected String owner;
    protected int parentJobId;
    @XmlElement(name = "public")
    protected boolean _public;
    @XmlElement(required = true, nillable = true)
    protected String reportParameters;
    @XmlElement(required = true, nillable = true)
    protected String reportUrl;
    @XmlElement(required = true, nillable = true)
    protected String runType;
    @XmlElement(required = true, nillable = true)
    protected String scheduleContext;
    @XmlElement(required = true, nillable = true)
    protected String scheduleDescription;
    @XmlElement(required = true, nillable = true)
    protected String scheduleParameters;
    @XmlElement(required = true, nillable = true)
    protected String scheduleSource;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(required = true, nillable = true)
    protected String status;
    @XmlElement(required = true, nillable = true)
    protected String statusDetail;
    @XmlElement(required = true, nillable = true)
    protected String storageType;
    @XmlElement(required = true, nillable = true)
    protected String userDescription;
    @XmlElement(required = true, nillable = true)
    protected String userJobName;
    protected boolean xmlDataAvailable;
    protected boolean xmlDataCompressed;
    @XmlElement(required = true, nillable = true)
    protected String xmlDataContentType;
    @XmlElement(required = true, nillable = true)
    protected String xschurl;

    /**
     * Gets the value of the bursting property.
     *
     */
    public boolean isBursting() {
        return bursting;
    }

    /**
     * Sets the value of the bursting property.
     *
     */
    public void setBursting(boolean value) {
        this.bursting = value;
    }

    /**
     * Gets the value of the burstingParameters property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBurstingParameters() {
        return burstingParameters;
    }

    /**
     * Sets the value of the burstingParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBurstingParameters(String value) {
        this.burstingParameters = value;
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
     * Gets the value of the dataLocator property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDataLocator() {
        return dataLocator;
    }

    /**
     * Sets the value of the dataLocator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDataLocator(String value) {
        this.dataLocator = value;
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
     * Gets the value of the deliveryDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeliveryDescription() {
        return deliveryDescription;
    }

    /**
     * Sets the value of the deliveryDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeliveryDescription(String value) {
        this.deliveryDescription = value;
    }

    /**
     * Gets the value of the deliveryParameters property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeliveryParameters() {
        return deliveryParameters;
    }

    /**
     * Sets the value of the deliveryParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeliveryParameters(String value) {
        this.deliveryParameters = value;
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
     */
    public int getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     *
     */
    public void setInstanceId(int value) {
        this.instanceId = value;
    }

    /**
     * Gets the value of the issuer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the jobGroup property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * Sets the value of the jobGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobGroup(String value) {
        this.jobGroup = value;
    }

    /**
     * Gets the value of the jobId property.
     *
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * Sets the value of the jobId property.
     *
     */
    public void setJobId(int value) {
        this.jobId = value;
    }

    /**
     * Gets the value of the jobSetId property.
     *
     */
    public int getJobSetId() {
        return jobSetId;
    }

    /**
     * Sets the value of the jobSetId property.
     *
     */
    public void setJobSetId(int value) {
        this.jobSetId = value;
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
     * Gets the value of the locale property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the notificationParameters property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationParameters() {
        return notificationParameters;
    }

    /**
     * Sets the value of the notificationParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationParameters(String value) {
        this.notificationParameters = value;
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
     */
    public int getParentJobId() {
        return parentJobId;
    }

    /**
     * Sets the value of the parentJobId property.
     *
     */
    public void setParentJobId(int value) {
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
     * Gets the value of the reportParameters property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportParameters() {
        return reportParameters;
    }

    /**
     * Sets the value of the reportParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportParameters(String value) {
        this.reportParameters = value;
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
     * Gets the value of the runType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRunType() {
        return runType;
    }

    /**
     * Sets the value of the runType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRunType(String value) {
        this.runType = value;
    }

    /**
     * Gets the value of the scheduleContext property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScheduleContext() {
        return scheduleContext;
    }

    /**
     * Sets the value of the scheduleContext property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScheduleContext(String value) {
        this.scheduleContext = value;
    }

    /**
     * Gets the value of the scheduleDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScheduleDescription() {
        return scheduleDescription;
    }

    /**
     * Sets the value of the scheduleDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScheduleDescription(String value) {
        this.scheduleDescription = value;
    }

    /**
     * Gets the value of the scheduleParameters property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScheduleParameters() {
        return scheduleParameters;
    }

    /**
     * Sets the value of the scheduleParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScheduleParameters(String value) {
        this.scheduleParameters = value;
    }

    /**
     * Gets the value of the scheduleSource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScheduleSource() {
        return scheduleSource;
    }

    /**
     * Sets the value of the scheduleSource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScheduleSource(String value) {
        this.scheduleSource = value;
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
     * Gets the value of the storageType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     * Sets the value of the storageType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStorageType(String value) {
        this.storageType = value;
    }

    /**
     * Gets the value of the userDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserDescription() {
        return userDescription;
    }

    /**
     * Sets the value of the userDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserDescription(String value) {
        this.userDescription = value;
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

    /**
     * Gets the value of the xmlDataAvailable property.
     *
     */
    public boolean isXmlDataAvailable() {
        return xmlDataAvailable;
    }

    /**
     * Sets the value of the xmlDataAvailable property.
     *
     */
    public void setXmlDataAvailable(boolean value) {
        this.xmlDataAvailable = value;
    }

    /**
     * Gets the value of the xmlDataCompressed property.
     *
     */
    public boolean isXmlDataCompressed() {
        return xmlDataCompressed;
    }

    /**
     * Sets the value of the xmlDataCompressed property.
     *
     */
    public void setXmlDataCompressed(boolean value) {
        this.xmlDataCompressed = value;
    }

    /**
     * Gets the value of the xmlDataContentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXmlDataContentType() {
        return xmlDataContentType;
    }

    /**
     * Sets the value of the xmlDataContentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXmlDataContentType(String value) {
        this.xmlDataContentType = value;
    }

    /**
     * Gets the value of the xschurl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXschurl() {
        return xschurl;
    }

    /**
     * Sets the value of the xschurl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXschurl(String value) {
        this.xschurl = value;
    }

}
