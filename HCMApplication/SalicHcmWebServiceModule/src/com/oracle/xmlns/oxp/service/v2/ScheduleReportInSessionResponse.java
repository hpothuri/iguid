
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
 *         &lt;element name="scheduleReportInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "scheduleReportInSessionReturn" })
@XmlRootElement(name = "scheduleReportInSessionResponse")
public class ScheduleReportInSessionResponse {

    @XmlElement(required = true)
    protected String scheduleReportInSessionReturn;

    /**
     * Gets the value of the scheduleReportInSessionReturn property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScheduleReportInSessionReturn() {
        return scheduleReportInSessionReturn;
    }

    /**
     * Sets the value of the scheduleReportInSessionReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScheduleReportInSessionReturn(String value) {
        this.scheduleReportInSessionReturn = value;
    }

}
