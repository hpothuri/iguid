
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
 *         &lt;element name="getScheduledReportDeliveryInfoReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobOutputDeliverysList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getScheduledReportDeliveryInfoReturn" })
@XmlRootElement(name = "getScheduledReportDeliveryInfoResponse")
public class GetScheduledReportDeliveryInfoResponse {

    @XmlElement(required = true)
    protected JobOutputDeliverysList getScheduledReportDeliveryInfoReturn;

    /**
     * Gets the value of the getScheduledReportDeliveryInfoReturn property.
     *
     * @return
     *     possible object is
     *     {@link JobOutputDeliverysList }
     *
     */
    public JobOutputDeliverysList getGetScheduledReportDeliveryInfoReturn() {
        return getScheduledReportDeliveryInfoReturn;
    }

    /**
     * Sets the value of the getScheduledReportDeliveryInfoReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link JobOutputDeliverysList }
     *
     */
    public void setGetScheduledReportDeliveryInfoReturn(JobOutputDeliverysList value) {
        this.getScheduledReportDeliveryInfoReturn = value;
    }

}
