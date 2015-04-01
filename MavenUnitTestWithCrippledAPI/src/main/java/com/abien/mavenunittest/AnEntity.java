package com.abien.mavenunittest;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */

@Entity
public class AnEntity {

    @Id
    private long id;
    private String content;
    
    
}
