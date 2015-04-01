package com.abien.patterns.business.txlistener;

import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class TXStatusListener {

    public void onInProgress(@Observes String msg){
        System.out.println("In progress: " + msg);
    }

    public void onSuccess(@Observes(during= TransactionPhase.AFTER_SUCCESS) String msg){
        System.out.println("After success: " + msg);
    }

    public void onFailure(@Observes(during= TransactionPhase.AFTER_FAILURE) String msg){
        System.out.println("After failure: " + msg);
    }
    
    public void beforeCompletion(@Observes(during= TransactionPhase.BEFORE_COMPLETION) EJBContext sc){
        System.out.println("Before completion: " + sc.getRollbackOnly());
        if(System.currentTimeMillis() % 2 == 0)
            sc.setRollbackOnly();
    }
}
