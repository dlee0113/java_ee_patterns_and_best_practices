package com.abien.ejbandcdi.control;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author blog.adam-bien.com
 */
@Stateless
public class OrderListener {

    public void onOrder(@Observes(during=TransactionPhase.AFTER_SUCCESS) String event){
        System.out.println("--: " + event);
    }
}
