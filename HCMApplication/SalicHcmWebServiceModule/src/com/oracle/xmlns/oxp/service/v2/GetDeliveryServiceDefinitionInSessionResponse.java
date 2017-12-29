
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
 *         &lt;element name="getDeliveryServiceDefinitionInSessionReturn" type="{http://xmlns.oracle.com/oxp/service/v2}DeliveryServiceDefinition"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getDeliveryServiceDefinitionInSessionReturn" })
@XmlRootElement(name = "getDeliveryServiceDefinitionInSessionResponse")
public class GetDeliveryServiceDefinitionInSessionResponse {

    @XmlElement(required = true)
    protected DeliveryServiceDefinition getDeliveryServiceDefinitionInSessionReturn;

    /**
     * Gets the value of the getDeliveryServiceDefinitionInSessionReturn property.
     *
     * @return
     *     possible object is
     *     {@link DeliveryServiceDefinition }
     *
     */
    public DeliveryServiceDefinition getGetDeliveryServiceDefinitionInSessionReturn() {
        return getDeliveryServiceDefinitionInSessionReturn;
    }

    /**
     * Sets the value of the getDeliveryServiceDefinitionInSessionReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link DeliveryServiceDefinition }
     *
     */
    public void setGetDeliveryServiceDefinitionInSessionReturn(DeliveryServiceDefinition value) {
        this.getDeliveryServiceDefinitionInSessionReturn = value;
    }

}
