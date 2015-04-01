package de.pizza42.business.order.entity;

import de.pizza42.business.order.boundary.Delicious;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pizza {

    @Id
    @Size(min=2,max=50)
    @Delicious
    private String name;
    @XmlTransient
    private int weight;


    public Pizza() {
    }

    public Pizza(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    

    @Override
    public String toString() {
        return "Pizza{" + "name=" + name + "weight=" + weight + '}';
    }


    
}
