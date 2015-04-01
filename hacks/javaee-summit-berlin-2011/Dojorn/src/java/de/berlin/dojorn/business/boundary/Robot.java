package de.berlin.dojorn.business.boundary;

import de.berlin.dojorn.business.tasks.boundary.Priority;
import de.berlin.dojorn.business.tasks.entity.Task;
import javax.enterprise.event.Observes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Robot {
    
    public void complete(@Observes @Priority(Priority.Level.HIGH) Task task){
        System.out.println("HI PRIORITY:  " + task);
    }
    
}
