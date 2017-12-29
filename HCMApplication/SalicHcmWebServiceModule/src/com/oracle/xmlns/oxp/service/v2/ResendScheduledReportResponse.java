
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="resendScheduledReportReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "resendScheduledReportReturn" })
@XmlRootElement(name = "resendScheduledReportResponse")
public class ResendScheduledReportResponse {

    protected boolean resendScheduledReportReturn;

    /**
     * Gets the value of the resendScheduledReportReturn property.
     *
     */
    public boolean isResendScheduledReportReturn() {
        return resendScheduledReportReturn;
    }

    /**
     * Sets the value of the resendScheduledReportReturn property.
     *
     */
    public void setResendScheduledReportReturn(boolean value) {
        this.resendScheduledReportReturn = value;
    }

}
