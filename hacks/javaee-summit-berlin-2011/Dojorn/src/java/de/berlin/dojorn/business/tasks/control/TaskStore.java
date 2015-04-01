package de.berlin.dojorn.business.tasks.control;

import de.berlin.dojorn.business.tasks.entity.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Singleton
@Startup
public class TaskStore {
    
    private List<Task> store;
    private List<AsyncContext> browsers;
    
    @Resource
    TimerService service;
    
    @PostConstruct
    public void initialize(){
        this.store = new ArrayList<Task>();
        this.browsers = new ArrayList<AsyncContext>();
    }
    
    public void oneNewTask(@Observes Task task){
        this.store.add(task);
    }
    
    public void onNewBrowserRequest(@Observes AsyncContext ctx){
        this.browsers.add(ctx);
    }
    
    @Schedule(minute="*",hour="*",second="*/5")
    public void dump(){
        System.out.println("----" + this.store + new Date());
        
        for (AsyncContext ctx: browsers) {
            try {
                ctx.getResponse().getWriter().println(this.store.toString());
                ctx.complete();
            } catch (IOException ex) {
                Logger.getLogger(TaskStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
