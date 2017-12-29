
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobInfosList complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JobInfosList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jobInfoList" type="{http://xmlns.oracle.com/oxp/service/v2}ArrayOfJobInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobInfosList", propOrder = { "jobInfoList" })
public class JobInfosList {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfJobInfo jobInfoList;

    /**
     * Gets the value of the jobInfoList property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfJobInfo }
     *
     */
    public ArrayOfJobInfo getJobInfoList() {
        return jobInfoList;
    }

    /**
     * Sets the value of the jobInfoList property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfJobInfo }
     *
     */
    public void setJobInfoList(ArrayOfJobInfo value) {
        this.jobInfoList = value;
    }

}
