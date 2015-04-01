/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Table(name="w_vehicle")
@Entity
@PowerValidator
public class Vehicle {
    
    @Id
    @GeneratedValue
    @XmlTransient
    private long id;
    
    //@Size(min=2,max=4)
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    
    
    public Vehicle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "name=" + name + '}';
    }
    
    
    
    
}
