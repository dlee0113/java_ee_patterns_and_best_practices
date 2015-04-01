package com.abien.patterns.business.txtracking.boundary;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author adam bien, adam-bien.com
*/
@Interceptors({CallAudit.class,Observable.class})
@Stateless
public class TXTracker {
    
    @Inject
    Event<String> txListeners;

    @Inject
    Event<EJBContext> beforeCompletionListeners;
    
    @Resource
    SessionContext sc;
    
    public void success(){
        txListeners.fire("[Event] succcess");
        System.out.println("Some [success] business code");
    }

    public void failureInBeforeCompletion(){
        System.out.println("Some [success] business code");
    }
    
    public void failure(){
        txListeners.fire("[Event] rollback");
        System.out.println("Some [failure] business code");
        sc.setRollbackOnly();
    }
}
