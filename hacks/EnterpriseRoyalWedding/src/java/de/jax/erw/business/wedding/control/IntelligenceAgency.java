package de.jax.erw.business.wedding.control;

import de.jax.erw.business.wedding.entity.WedLock;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class IntelligenceAgency {
    
    
    public void onSuccessWedLock(@Observes(during= TransactionPhase.AFTER_SUCCESS) WedLock lock){
        System.out.println("----FAZ Writing a nice article: " + lock);
    }

    public void onDisasterWedLock(@Observes(during= TransactionPhase.AFTER_FAILURE) WedLock lock){
        System.out.println("----BILD Writing a nice article: " + lock);
    }
    
}
