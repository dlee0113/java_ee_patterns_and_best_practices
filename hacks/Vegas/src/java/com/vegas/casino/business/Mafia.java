package com.vegas.casino.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class Mafia {

    @Asynchronous
    public void onInterestingThings(@Observes @Money(Money.Amount.LOT) String message){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mafia.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("---Here is mafia: " + message);
    }
}
