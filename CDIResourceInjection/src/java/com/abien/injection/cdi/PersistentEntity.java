package com.abien.injection.cdi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersistentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public PersistentEntity() {}

    public PersistentEntity(String name) {
        this.name = name;
    }
}
