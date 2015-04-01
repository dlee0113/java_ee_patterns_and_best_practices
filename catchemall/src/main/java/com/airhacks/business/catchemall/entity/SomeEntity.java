package com.airhacks.business.catchemall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author adam-bien.com
 */
@Entity
public class SomeEntity {

    @Id
    private String name;

    private String description;

    @Version
    private long version;

    public SomeEntity(String name) {
        this.name = name;
    }

    public SomeEntity() {
    }

    public String getName() {
        return name;
    }

    public void makeDirty() {
        this.description = "duke " + System.currentTimeMillis();
        this.version = System.currentTimeMillis();
    }

}
