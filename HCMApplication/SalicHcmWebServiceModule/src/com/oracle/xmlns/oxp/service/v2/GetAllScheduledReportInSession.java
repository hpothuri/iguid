
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
 *         &lt;element name="filter" type="{http://xmlns.oracle.com/oxp/service/v2}JobFilterProperties"/&gt;
 *         &lt;element name="beginIdx" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bipSessionToken" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "filter", "beginIdx", "bipSessionToken" })
@XmlRootElement(name = "getAllScheduledReportInSession")
public class GetAllScheduledReportInSession {

    @XmlElement(required = true)
    protected JobFilterProperties filter;
    protected int beginIdx;
    @XmlElement(required = true)
    protected String bipSessionToken;

    /**
     * Gets the value of the filter property.
     *
     * @return
     *     possible object is
     *     {@link JobFilterProperties }
     *
     */
    public JobFilterProperties getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     *
     * @param value
     *     allowed object is
     *     {@link JobFilterProperties }
     *
     */
    public void setFilter(JobFilterProperties value) {
        this.filter = value;
    }

    /**
     * Gets the value of the beginIdx property.
     *
     */
    public int getBeginIdx() {
        return beginIdx;
    }

    /**
     * Sets the value of the beginIdx property.
     *
     */
    public void setBeginIdx(int value) {
        this.beginIdx = value;
    }

    /**
     * Gets the value of the bipSessionToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBipSessionToken() {
        return bipSessionToken;
    }

    /**
     * Sets the value of the bipSessionToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBipSessionToken(String value) {
        this.bipSessionToken = value;
    }

}
