
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
 *         &lt;element name="getScheduledJobInfoInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}JobDetail"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getScheduledJobInfoInSessionReturn" })
@XmlRootElement(name = "getScheduledJobInfoInSessionResponse")
public class GetScheduledJobInfoInSessionResponse {

    @XmlElement(required = true)
    protected JobDetail getScheduledJobInfoInSessionReturn;

    /**
     * Gets the value of the getScheduledJobInfoInSessionReturn property.
     *
     * @return
     *     possible object is
     *     {@link JobDetail }
     *
     */
    public JobDetail getGetScheduledJobInfoInSessionReturn() {
        return getScheduledJobInfoInSessionReturn;
    }

    /**
     * Sets the value of the getScheduledJobInfoInSessionReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link JobDetail }
     *
     */
    public void setGetScheduledJobInfoInSessionReturn(JobDetail value) {
        this.getScheduledJobInfoInSessionReturn = value;
    }

}
