
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
 *         &lt;element name="getScheduledReportOutputInfoReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobOutputsList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getScheduledReportOutputInfoReturn" })
@XmlRootElement(name = "getScheduledReportOutputInfoResponse")
public class GetScheduledReportOutputInfoResponse {

    @XmlElement(required = true)
    protected JobOutputsList getScheduledReportOutputInfoReturn;

    /**
     * Gets the value of the getScheduledReportOutputInfoReturn property.
     *
     * @return
     *     possible object is
     *     {@link JobOutputsList }
     *
     */
    public JobOutputsList getGetScheduledReportOutputInfoReturn() {
        return getScheduledReportOutputInfoReturn;
    }

    /**
     * Sets the value of the getScheduledReportOutputInfoReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link JobOutputsList }
     *
     */
    public void setGetScheduledReportOutputInfoReturn(JobOutputsList value) {
        this.getScheduledReportOutputInfoReturn = value;
    }

}
