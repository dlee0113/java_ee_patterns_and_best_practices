package org.onedaytalk.hack.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.interceptor.Interceptors;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Interceptors(TXRetryManger.class)
@Stateless
public class Administrator {
    
    
    @Asynchronous
    public void onConfigurationChange(@Observes(during= TransactionPhase.AFTER_SUCCESS) @Importance(Importance.Level.LOW) String message){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----nothing Ok - go with it! " + message);
    
    }
    
    public void gatherFailures(@Observes(during= TransactionPhase.AFTER_FAILURE) String messge){
        System.out.println("Failure! " + messge);
    }
    
}
