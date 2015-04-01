/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.entity;

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
public class Attendee {
  
    @Asynchronous
    public void wakeMeUp(@Observes(during= TransactionPhase.AFTER_SUCCESS) String msg){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Attendee.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("---- No more sleeping: " + msg + System.currentTimeMillis());
    }
    public void ignore(@Observes(during= TransactionPhase.AFTER_FAILURE) String msg){
        System.out.println("---- Just sleeping (is rolled back): " + msg);
    }
}
