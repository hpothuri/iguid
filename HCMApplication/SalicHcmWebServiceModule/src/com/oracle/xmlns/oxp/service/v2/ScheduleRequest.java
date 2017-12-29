
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduleRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ScheduleRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookBindingOutputOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="dataModelUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deliveryChannels" type="{http://xmlns.oracle.com/oxp/service/v2}DeliveryChannels"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobLocale" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="jobTZ" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mergeOutputOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notificationPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notificationServer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notificationTo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notificationUserName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notifyHttpWhenFailed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyHttpWhenSkipped" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyHttpWhenSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyHttpWhenWarning" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyWhenFailed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyWhenSkipped" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyWhenSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="notifyWhenWarning" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="recurrenceExpression" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recurrenceExpressionType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="repeatCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="repeatInterval" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="reportRequest" type="{http://xmlns.oracle.com/oxp/service/v2}ReportRequest"/&gt;
 *         &lt;element name="saveDataOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="saveOutputOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="scheduleBurstingOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="scheduleBurstringOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="schedulePublicOption" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="useUTF8Option" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="userJobDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "ScheduleRequest",
         propOrder =
         { "bookBindingOutputOption", "dataModelUrl", "deliveryChannels", "endDate", "jobLocale", "jobTZ",
           "mergeOutputOption", "notificationPassword", "notificationServer", "notificationTo", "notificationUserName",
           "notifyHttpWhenFailed", "notifyHttpWhenSkipped", "notifyHttpWhenSuccess", "notifyHttpWhenWarning",
           "notifyWhenFailed", "notifyWhenSkipped", "notifyWhenSuccess", "notifyWhenWarning", "recurrenceExpression",
           "recurrenceExpressionType", "repeatCount", "repeatInterval", "reportRequest", "saveDataOption",
           "saveOutputOption", "scheduleBurstingOption", "scheduleBurstringOption", "schedulePublicOption", "startDate",
           "useUTF8Option", "userJobDesc", "userJobName"
    })
public class ScheduleRequest {

    protected boolean bookBindingOutputOption;
    @XmlElement(required = true, nillable = true)
    protected String dataModelUrl;
    @XmlElement(required = true, nillable = true)
    protected DeliveryChannels deliveryChannels;
    @XmlElement(required = true, nillable = true)
    protected String endDate;
    @XmlElement(required = true, nillable = true)
    protected String jobLocale;
    @XmlElement(required = true, nillable = true)
    protected String jobTZ;
    protected boolean mergeOutputOption;
    @XmlElement(required = true, nillable = true)
    protected String notificationPassword;
    @XmlElement(required = true, nillable = true)
    protected String notificationServer;
    @XmlElement(required = true, nillable = true)
    protected String notificationTo;
    @XmlElement(required = true, nillable = true)
    protected String notificationUserName;
    protected boolean notifyHttpWhenFailed;
    protected boolean notifyHttpWhenSkipped;
    protected boolean notifyHttpWhenSuccess;
    protected boolean notifyHttpWhenWarning;
    protected boolean notifyWhenFailed;
    protected boolean notifyWhenSkipped;
    protected boolean notifyWhenSuccess;
    protected boolean notifyWhenWarning;
    @XmlElement(required = true, nillable = true)
    protected String recurrenceExpression;
    @XmlElement(required = true, nillable = true)
    protected String recurrenceExpressionType;
    protected int repeatCount;
    protected int repeatInterval;
    @XmlElement(required = true, nillable = true)
    protected ReportRequest reportRequest;
    protected boolean saveDataOption;
    protected boolean saveOutputOption;
    protected boolean scheduleBurstingOption;
    protected boolean scheduleBurstringOption;
    protected boolean schedulePublicOption;
    @XmlElement(required = true, nillable = true)
    protected String startDate;
    protected boolean useUTF8Option;
    @XmlElement(required = true, nillable = true)
    protected String userJobDesc;
    @XmlElement(required = true, nillable = true)
    protected String userJobName;

    /**
     * Gets the value of the bookBindingOutputOption property.
     *
     */
    public boolean isBookBindingOutputOption() {
        return bookBindingOutputOption;
    }

    /**
     * Sets the value of the bookBindingOutputOption property.
     *
     */
    public void setBookBindingOutputOption(boolean value) {
        this.bookBindingOutputOption = value;
    }

    /**
     * Gets the value of the dataModelUrl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDataModelUrl() {
        return dataModelUrl;
    }

    /**
     * Sets the value of the dataModelUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDataModelUrl(String value) {
        this.dataModelUrl = value;
    }

    /**
     * Gets the value of the deliveryChannels property.
     *
     * @return
     *     possible object is
     *     {@link DeliveryChannels }
     *
     */
    public DeliveryChannels getDeliveryChannels() {
        return deliveryChannels;
    }

    /**
     * Sets the value of the deliveryChannels property.
     *
     * @param value
     *     allowed object is
     *     {@link DeliveryChannels }
     *
     */
    public void setDeliveryChannels(DeliveryChannels value) {
        this.deliveryChannels = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the jobLocale property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobLocale() {
        return jobLocale;
    }

    /**
     * Sets the value of the jobLocale property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobLocale(String value) {
        this.jobLocale = value;
    }

    /**
     * Gets the value of the jobTZ property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getJobTZ() {
        return jobTZ;
    }

    /**
     * Sets the value of the jobTZ property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setJobTZ(String value) {
        this.jobTZ = value;
    }

    /**
     * Gets the value of the mergeOutputOption property.
     *
     */
    public boolean isMergeOutputOption() {
        return mergeOutputOption;
    }

    /**
     * Sets the value of the mergeOutputOption property.
     *
     */
    public void setMergeOutputOption(boolean value) {
        this.mergeOutputOption = value;
    }

    /**
     * Gets the value of the notificationPassword property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationPassword() {
        return notificationPassword;
    }

    /**
     * Sets the value of the notificationPassword property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationPassword(String value) {
        this.notificationPassword = value;
    }

    /**
     * Gets the value of the notificationServer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationServer() {
        return notificationServer;
    }

    /**
     * Sets the value of the notificationServer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationServer(String value) {
        this.notificationServer = value;
    }

    /**
     * Gets the value of the notificationTo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationTo() {
        return notificationTo;
    }

    /**
     * Sets the value of the notificationTo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationTo(String value) {
        this.notificationTo = value;
    }

    /**
     * Gets the value of the notificationUserName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationUserName() {
        return notificationUserName;
    }

    /**
     * Sets the value of the notificationUserName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationUserName(String value) {
        this.notificationUserName = value;
    }

    /**
     * Gets the value of the notifyHttpWhenFailed property.
     *
     */
    public boolean isNotifyHttpWhenFailed() {
        return notifyHttpWhenFailed;
    }

    /**
     * Sets the value of the notifyHttpWhenFailed property.
     *
     */
    public void setNotifyHttpWhenFailed(boolean value) {
        this.notifyHttpWhenFailed = value;
    }

    /**
     * Gets the value of the notifyHttpWhenSkipped property.
     *
     */
    public boolean isNotifyHttpWhenSkipped() {
        return notifyHttpWhenSkipped;
    }

    /**
     * Sets the value of the notifyHttpWhenSkipped property.
     *
     */
    public void setNotifyHttpWhenSkipped(boolean value) {
        this.notifyHttpWhenSkipped = value;
    }

    /**
     * Gets the value of the notifyHttpWhenSuccess property.
     *
     */
    public boolean isNotifyHttpWhenSuccess() {
        return notifyHttpWhenSuccess;
    }

    /**
     * Sets the value of the notifyHttpWhenSuccess property.
     *
     */
    public void setNotifyHttpWhenSuccess(boolean value) {
        this.notifyHttpWhenSuccess = value;
    }

    /**
     * Gets the value of the notifyHttpWhenWarning property.
     *
     */
    public boolean isNotifyHttpWhenWarning() {
        return notifyHttpWhenWarning;
    }

    /**
     * Sets the value of the notifyHttpWhenWarning property.
     *
     */
    public void setNotifyHttpWhenWarning(boolean value) {
        this.notifyHttpWhenWarning = value;
    }

    /**
     * Gets the value of the notifyWhenFailed property.
     *
     */
    public boolean isNotifyWhenFailed() {
        return notifyWhenFailed;
    }

    /**
     * Sets the value of the notifyWhenFailed property.
     *
     */
    public void setNotifyWhenFailed(boolean value) {
        this.notifyWhenFailed = value;
    }

    /**
     * Gets the value of the notifyWhenSkipped property.
     *
     */
    public boolean isNotifyWhenSkipped() {
        return notifyWhenSkipped;
    }

    /**
     * Sets the value of the notifyWhenSkipped property.
     *
     */
    public void setNotifyWhenSkipped(boolean value) {
        this.notifyWhenSkipped = value;
    }

    /**
     * Gets the value of the notifyWhenSuccess property.
     *
     */
    public boolean isNotifyWhenSuccess() {
        return notifyWhenSuccess;
    }

    /**
     * Sets the value of the notifyWhenSuccess property.
     *
     */
    public void setNotifyWhenSuccess(boolean value) {
        this.notifyWhenSuccess = value;
    }

    /**
     * Gets the value of the notifyWhenWarning property.
     *
     */
    public boolean isNotifyWhenWarning() {
        return notifyWhenWarning;
    }

    /**
     * Sets the value of the notifyWhenWarning property.
     *
     */
    public void setNotifyWhenWarning(boolean value) {
        this.notifyWhenWarning = value;
    }

    /**
     * Gets the value of the recurrenceExpression property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRecurrenceExpression() {
        return recurrenceExpression;
    }

    /**
     * Sets the value of the recurrenceExpression property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRecurrenceExpression(String value) {
        this.recurrenceExpression = value;
    }

    /**
     * Gets the value of the recurrenceExpressionType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRecurrenceExpressionType() {
        return recurrenceExpressionType;
    }

    /**
     * Sets the value of the recurrenceExpressionType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRecurrenceExpressionType(String value) {
        this.recurrenceExpressionType = value;
    }

    /**
     * Gets the value of the repeatCount property.
     *
     */
    public int getRepeatCount() {
        return repeatCount;
    }

    /**
     * Sets the value of the repeatCount property.
     *
     */
    public void setRepeatCount(int value) {
        this.repeatCount = value;
    }

    /**
     * Gets the value of the repeatInterval property.
     *
     */
    public int getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * Sets the value of the repeatInterval property.
     *
     */
    public void setRepeatInterval(int value) {
        this.repeatInterval = value;
    }

    /**
     * Gets the value of the reportRequest property.
     *
     * @return
     *     possible object is
     *     {@link ReportRequest }
     *
     */
    public ReportRequest getReportRequest() {
        return reportRequest;
    }

    /**
     * Sets the value of the reportRequest property.
     *
     * @param value
     *     allowed object is
     *     {@link ReportRequest }
     *
     */
    public void setReportRequest(ReportRequest value) {
        this.reportRequest = value;
    }

    /**
     * Gets the value of the saveDataOption property.
     *
     */
    public boolean isSaveDataOption() {
        return saveDataOption;
    }

    /**
     * Sets the value of the saveDataOption property.
     *
     */
    public void setSaveDataOption(boolean value) {
        this.saveDataOption = value;
    }

    /**
     * Gets the value of the saveOutputOption property.
     *
     */
    public boolean isSaveOutputOption() {
        return saveOutputOption;
    }

    /**
     * Sets the value of the saveOutputOption property.
     *
     */
    public void setSaveOutputOption(boolean value) {
        this.saveOutputOption = value;
    }

    /**
     * Gets the value of the scheduleBurstingOption property.
     *
     */
    public boolean isScheduleBurstingOption() {
        return scheduleBurstingOption;
    }

    /**
     * Sets the value of the scheduleBurstingOption property.
     *
     */
    public void setScheduleBurstingOption(boolean value) {
        this.scheduleBurstingOption = value;
    }

    /**
     * Gets the value of the scheduleBurstringOption property.
     *
     */
    public boolean isScheduleBurstringOption() {
        return scheduleBurstringOption;
    }

    /**
     * Sets the value of the scheduleBurstringOption property.
     *
     */
    public void setScheduleBurstringOption(boolean value) {
        this.scheduleBurstringOption = value;
    }

    /**
     * Gets the value of the schedulePublicOption property.
     *
     */
    public boolean isSchedulePublicOption() {
        return schedulePublicOption;
    }

    /**
     * Sets the value of the schedulePublicOption property.
     *
     */
    public void setSchedulePublicOption(boolean value) {
        this.schedulePublicOption = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the useUTF8Option property.
     *
     */
    public boolean isUseUTF8Option() {
        return useUTF8Option;
    }

    /**
     * Sets the value of the useUTF8Option property.
     *
     */
    public void setUseUTF8Option(boolean value) {
        this.useUTF8Option = value;
    }

    /**
     * Gets the value of the userJobDesc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserJobDesc() {
        return userJobDesc;
    }

    /**
     * Sets the value of the userJobDesc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserJobDesc(String value) {
        this.userJobDesc = value;
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
