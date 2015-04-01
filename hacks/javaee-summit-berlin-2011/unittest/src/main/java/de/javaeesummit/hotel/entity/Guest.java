package de.javaeesummit.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Entity
public class Guest {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }
    
}
