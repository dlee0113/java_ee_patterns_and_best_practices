package de.duke.mugs.business.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DukeMug {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean guitar;

    public DukeMug(String name, boolean guitar) {
        this.name = name;
        this.guitar = guitar;
    }

    public DukeMug() {
    }

    @Override
    public String toString() {
        return "DukeMug{" + "name=" + name + "guitar=" + guitar + '}';
    }

    

}
