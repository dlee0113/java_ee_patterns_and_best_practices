package com.abien.patterns.business.txtracking.boundary;

import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class Observable {
    @Resource
    SessionContext sc;
    
    @Inject
    Event<EJBContext> txProgressListeners;

    @AroundInvoke
    public Object onCall(InvocationContext ic) throws Exception{
        try{
            return ic.proceed();
        }finally{
            txProgressListeners.fire(sc);
        }
    }
}
