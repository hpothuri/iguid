
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobOutputDeliverysList complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobOutputDeliverysList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jobOutputDeliveryList" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfJobOutputDelivery"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobOutputDeliverysList", propOrder = { "jobOutputDeliveryList" })
public class JobOutputDeliverysList {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfJobOutputDelivery jobOutputDeliveryList;

    /**
     * Gets the value of the jobOutputDeliveryList property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfJobOutputDelivery }
     *
     */
    public ArrayOfJobOutputDelivery getJobOutputDeliveryList() {
        return jobOutputDeliveryList;
    }

    /**
     * Sets the value of the jobOutputDeliveryList property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfJobOutputDelivery }
     *
     */
    public void setJobOutputDeliveryList(ArrayOfJobOutputDelivery value) {
        this.jobOutputDeliveryList = value;
    }

}
