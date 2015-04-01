package com.javaone.coolparts;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class CoolnessObserver {
    
    
    public void onSomething(@Observes(during= TransactionPhase.AFTER_SUCCESS) @Coolness(Coolness.Factor.VERY_COOL) String message){
        System.out.println("+++Event: " + message);
    }

    @Asynchronous
    public Future<String> onSomethingFailing(@Observes(during= TransactionPhase.AFTER_FAILURE) @Coolness(Coolness.Factor.VERY_COOL) String message){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CoolnessObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("+++(Rollback)Event: " + message);
        return new AsyncResult<String>("42");
    }
    
}
