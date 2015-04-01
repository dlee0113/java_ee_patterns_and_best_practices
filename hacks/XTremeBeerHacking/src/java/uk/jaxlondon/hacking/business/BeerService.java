/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author abien
 */
@Stateless
public class BeerService {
    
    
    @Asynchronous
    public void onBeerRequest(@Observes(during= TransactionPhase.AFTER_COMPLETION) String request){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BeerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Bringing some beer to you! " + request);
    }

    public void onFakeRequest(@Observes(during= TransactionPhase.AFTER_FAILURE) String request){
        System.out.println("NOTHING will happen " + request);
    }
}
