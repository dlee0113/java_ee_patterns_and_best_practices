package de.berlin.dojorn.business.tasks.boundary;

import de.berlin.dojorn.business.tasks.control.Compressor;
import de.berlin.dojorn.business.tasks.control.DescriptionFormatter;
import de.berlin.dojorn.business.tasks.control.Formatter;
import de.berlin.dojorn.business.tasks.entity.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Interceptors(TaskAuditor.class)
public class TaskService {
    
    @Inject
    private String nameToUse;
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Instance<Formatter> formatters;
    
    @Inject @Priority(Priority.Level.HIGH)
    Event<Task> tasks;
    
    @Resource
    SessionContext sc;
    
    @Inject
    Compressor compressor;
    
    public Task save(Task task){
        compressor.compress(task);
        tasks.fire(task);
        for (Formatter formatter : formatters) {
            formatter.format(task);
            System.out.println("Formatter: " + formatter);
        }
        return em.merge(task);
        //sc.setRollbackOnly();
        
    }
    
    
    @Produces
    public List<Formatter> allFormatters(){
        List<Formatter> retVal = new ArrayList<Formatter>();
        for (Formatter formatter : formatters) {
            formatter.withName(nameToUse);
            retVal.add(formatter);
        }
        return retVal;
    }
}
