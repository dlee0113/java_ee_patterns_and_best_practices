package de.berlin.dojorn.presentation;

import de.berlin.dojorn.business.tasks.boundary.TaskService;
import de.berlin.dojorn.business.tasks.control.Formatter;
import de.berlin.dojorn.business.tasks.entity.Task;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class Index {
    
    @Inject
    TaskService service;
    
    @Inject
    List<Formatter> formatter;
    
    private Task task = new Task();

    public List<Formatter> getFormatter() {
        return formatter;
    }
    
    
    public String yourList(){
        return "enjoy!";
    }

    public Task getTask() {
        return task;
    }
    
    public Object saveTask(){
        System.out.println("---- " + task);
        service.save(task);
        return null;
    }
    
    
}
