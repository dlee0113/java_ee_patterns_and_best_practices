package com.javaone.coolparts.two;

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
public class MessageObserver {
    
    @Asynchronous
    public Future<String> observeSomething(@Observes String message){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("### got message: " + message);
        return new AsyncResult<String>("Really nice");
    
    }
    
    
    public void onFailure(@Observes(during= TransactionPhase.AFTER_FAILURE) String message){
        System.out.println("!!!!---- we have a problem");
    }   
}
