
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
 *         &lt;element name="deleteScheduleReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "deleteScheduleReturn" })
@XmlRootElement(name = "deleteScheduleResponse")
public class DeleteScheduleResponse {

    protected boolean deleteScheduleReturn;

    /**
     * Gets the value of the deleteScheduleReturn property.
     *
     */
    public boolean isDeleteScheduleReturn() {
        return deleteScheduleReturn;
    }

    /**
     * Sets the value of the deleteScheduleReturn property.
     *
     */
    public void setDeleteScheduleReturn(boolean value) {
        this.deleteScheduleReturn = value;
    }

}
