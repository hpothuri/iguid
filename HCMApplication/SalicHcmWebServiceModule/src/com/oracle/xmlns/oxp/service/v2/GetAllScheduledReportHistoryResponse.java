
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
 *         &lt;element name="getAllScheduledReportHistoryReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobInfosList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getAllScheduledReportHistoryReturn" })
@XmlRootElement(name = "getAllScheduledReportHistoryResponse")
public class GetAllScheduledReportHistoryResponse {

    @XmlElement(required = true)
    protected JobInfosList getAllScheduledReportHistoryReturn;

    /**
     * Gets the value of the getAllScheduledReportHistoryReturn property.
     *
     * @return
     *     possible object is
     *     {@link JobInfosList }
     *
     */
    public JobInfosList getGetAllScheduledReportHistoryReturn() {
        return getAllScheduledReportHistoryReturn;
    }

    /**
     * Sets the value of the getAllScheduledReportHistoryReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link JobInfosList }
     *
     */
    public void setGetAllScheduledReportHistoryReturn(JobInfosList value) {
        this.getAllScheduledReportHistoryReturn = value;
    }

}
