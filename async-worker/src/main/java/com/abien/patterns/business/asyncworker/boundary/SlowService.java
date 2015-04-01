package com.abien.patterns.business.asyncworker.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class SlowService {
    
    @Resource
    SessionContext ctx;
    
    @Inject
    Executor executor;
    
    SlowService thiz;

    @Resource
    SessionContext sc;
    
    @PostConstruct
    public void initialize(){
        thiz = sc.getBusinessObject(SlowService.class);
    }

    public void selfInvocation(){
        thiz.slowMethod();
    }
    
    
    @Asynchronous
    public void slowMethod(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {}
    }
    
    @Asynchronous
    public void performIfNotCancelled(List<Runnable> workQueue){
        for (Runnable runnable : workQueue) {
            if(ctx.wasCancelCalled()){
                return;
            }
            runnable.run();
        }
    }
    
    
    @Asynchronous
    public Future<String> slowWithResult(){
        //really long computation
        return new AsyncResult<String>("42");
    }
    
    public String invoke(){
        Runnable command = new Runnable() {

            @Override
            public void run() {
                System.out.println("-before-");
                try {
                    Thread.sleep(2000);
                      System.out.println("-after-");
                } catch (InterruptedException ex) {
                    Logger.getLogger(SlowService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        executor.execute(command);
        return "performed";
    
    }
    
          
}
