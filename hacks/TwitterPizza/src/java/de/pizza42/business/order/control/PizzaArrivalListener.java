/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pizza42.business.order.control;

import de.pizza42.business.order.boundary.Quality;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Qualifier;

public class PizzaArrivalListener {

    
    public void onArrival(@Observes(during=TransactionPhase.AFTER_SUCCESS) @Quality(Quality.Level.DELICIOUS) String name){
        System.out.println("-Delicious-from listener: " + name);
    }

    public void onArrivalLater(@Observes(during=TransactionPhase.AFTER_FAILURE) @Quality(Quality.Level.GUM) String name){
        System.out.println("-Ok-later from listener: " + name);
    }
}
