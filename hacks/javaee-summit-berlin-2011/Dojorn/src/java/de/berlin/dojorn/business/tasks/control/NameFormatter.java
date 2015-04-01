package de.berlin.dojorn.business.tasks.control;

import de.berlin.dojorn.business.tasks.entity.Task;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class NameFormatter implements Formatter {
   
    private String name;

    @Inject
    public NameFormatter(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public Task format(Task task){
       task.setName(this.name);
       return task;
    }
    
    @Override
    public void withName(String name) {
        System.out.println("---- " + name);
    }
    
}
