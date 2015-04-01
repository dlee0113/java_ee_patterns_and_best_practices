package com.abien.patterns.threading.longpolling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class EventBroker {
    
    private CopyOnWriteArrayList<AsyncContext> contexts = new CopyOnWriteArrayList<AsyncContext>();
    
    public void onNewListener(@Observes AsyncContext ac){
        contexts.add(ac);
    }
    
    public void onNewEvent(@Observes String message){
        for (AsyncContext asyncContext : contexts) {
            try {
                PrintWriter writer = asyncContext.getResponse().getWriter();
                writer.println(message);
                writer.flush();
                asyncContext.complete();
            } catch (IOException ex) {
                throw new IllegalStateException("Cannot write async message",ex);
            }finally{
                contexts.remove(asyncContext);
            }
        }
    }
}
