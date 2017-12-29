
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
 *         &lt;element name="getScheduledReportStatusInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobStatus"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getScheduledReportStatusInSessionReturn" })
@XmlRootElement(name = "getScheduledReportStatusInSessionResponse")
public class GetScheduledReportStatusInSessionResponse {

    @XmlElement(required = true)
    protected JobStatus getScheduledReportStatusInSessionReturn;

    /**
     * Gets the value of the getScheduledReportStatusInSessionReturn property.
     *
     * @return
     *     possible object is
     *     {@link JobStatus }
     *
     */
    public JobStatus getGetScheduledReportStatusInSessionReturn() {
        return getScheduledReportStatusInSessionReturn;
    }

    /**
     * Sets the value of the getScheduledReportStatusInSessionReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link JobStatus }
     *
     */
    public void setGetScheduledReportStatusInSessionReturn(JobStatus value) {
        this.getScheduledReportStatusInSessionReturn = value;
    }

}
