package com.abien.patterns.pubsub.business;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class MessageListener {
    
    @Asynchronous
    public void onImportantMessage(@Observes @Importance(Importance.Degree.HIGH) String message){
        System.out.println("+Important " + message);
        throw new IllegalStateException("Something went wrong");
    }

    public void onTenuousMessage(@Observes(during=TransactionPhase.AFTER_COMPLETION) @Importance(Importance.Degree.LOW) String message){
        System.out.println("+Tenuous " + message);
    }

    public void onFailure(@Observes(during=TransactionPhase.AFTER_FAILURE) String message){
        System.out.println("--- " + message);
    }
    
}
