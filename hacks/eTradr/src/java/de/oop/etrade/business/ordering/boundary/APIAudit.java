package de.oop.etrade.business.ordering.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class APIAudit {


    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception{
        System.out.println("--- " + context.getMethod());
        return context.proceed();
    }
}
