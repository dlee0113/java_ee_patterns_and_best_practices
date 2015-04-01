package de.berlin.dojorn.business.mailing;

import de.berlin.dojorn.business.tasks.boundary.Priority;
import de.berlin.dojorn.business.tasks.entity.Task;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.Any;

public class Spammer {
    
    public void onSuccessfulTaskCreation(@Observes(during= TransactionPhase.AFTER_SUCCESS) @Priority(Priority.Level.LOW) Task task){
        System.out.println("onSuccessful Success: " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Spammer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onFailure(@Observes(during= TransactionPhase.AFTER_FAILURE) Task task){
        System.out.println("---- Failure: " + task);
    }
    
}
