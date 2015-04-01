package de.jax.erw.business.wedding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class WedLock {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Size(min=1,max=5)
    private String name;
    private boolean success;

    public WedLock(String name, boolean success) {
        this.name = name;
        this.success = success;
    }

    public WedLock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "WedLock{" + "id=" + id + ", name=" + name + ", success=" + success + '}';
    }
    
    
    
}
