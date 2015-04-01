package de.jax.erw.business.wedding.control;

import de.jax.erw.business.wedding.entity.WedLock;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class NewsFilter {

    private CopyOnWriteArrayList<WedLock> news;
   
    @Inject 
    private Instance<Filter> filters;
    
    //@Inject
    private String email ="adf";
    
    //@Inject
    private String greeting;
    
    @PostConstruct
    public void initialize(){
        news = new CopyOnWriteArrayList<WedLock>();
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void filterNews(@Observes WedLock lock){
        System.out.println("..... " + filters);
        for (Filter filter : filters) {
            System.out.println("Filter" + filter);
            if(filter.censor(lock)){
                System.out.println("------------ Censored!");
            }else{
                news.add(lock);
            }
        }
        //return new AsyncResult<WedLock>(lock);
    }
    
    
    @Schedule(minute="*",second="*/5",hour="*")
    public void distributeEvents(){
        System.out.println("news: " +news + email + greeting);
        news.clear();
    }
    
    
    
}
