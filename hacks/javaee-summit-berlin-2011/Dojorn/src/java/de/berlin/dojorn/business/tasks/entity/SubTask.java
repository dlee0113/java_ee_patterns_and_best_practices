package de.berlin.dojorn.business.tasks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Entity
public class SubTask {
    
    @Id
    @GeneratedValue
    private long id;
    private boolean completed;

    public SubTask() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
    
    
    
}
