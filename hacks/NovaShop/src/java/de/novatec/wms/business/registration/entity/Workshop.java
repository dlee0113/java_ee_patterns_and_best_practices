package de.novatec.wms.business.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author blog.adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Workshop {


    @XmlTransient
    @Id
    @GeneratedValue
    private long id;

    private String name;
    @Min(3) @Max(100)
    private int capacity;


    public Workshop() {
    }

    public Workshop(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Workshop{" + "name=" + name + "capacity=" + capacity + '}';
    }

    public long getId() {
        return this.id;
    }

}
