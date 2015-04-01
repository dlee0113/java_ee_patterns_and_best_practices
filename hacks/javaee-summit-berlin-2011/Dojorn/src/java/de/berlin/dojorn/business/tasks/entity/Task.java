package de.berlin.dojorn.business.tasks.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Task {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Size(min=2,max=50)
    @XmlAttribute(name="hugo")
    private String name;
    @Size(min=2,max=50)
    private String description;

    @XmlTransient
    @OneToOne(fetch= FetchType.LAZY,cascade= CascadeType.MERGE)
    private SubTask subTask;
    
    public Task() {
        this.subTask = new SubTask();
    }

    public Task(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    
    

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" + "name=" + name + ", description=" + description + '}';
    }
    
    
    
}
