package com.abien.patterns.business.txlistener;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class AsychronousTXStatusListener {

    @Asynchronous
    public void onInProgress(@Observes String msg){
    }

    @Asynchronous
    public void onSuccess(@Observes(during= TransactionPhase.AFTER_SUCCESS) String msg){
    }

    @Asynchronous
    public void onFailure(@Observes(during= TransactionPhase.AFTER_FAILURE) String msg){
    }
}
