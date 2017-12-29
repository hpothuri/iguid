
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
 *         &lt;element name="resumeScheduleInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "resumeScheduleInSessionReturn" })
@XmlRootElement(name = "resumeScheduleInSessionResponse")
public class ResumeScheduleInSessionResponse {

    protected boolean resumeScheduleInSessionReturn;

    /**
     * Gets the value of the resumeScheduleInSessionReturn property.
     *
     */
    public boolean isResumeScheduleInSessionReturn() {
        return resumeScheduleInSessionReturn;
    }

    /**
     * Sets the value of the resumeScheduleInSessionReturn property.
     *
     */
    public void setResumeScheduleInSessionReturn(boolean value) {
        this.resumeScheduleInSessionReturn = value;
    }

}
