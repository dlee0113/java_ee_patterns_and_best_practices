package com.abien.patterns.business.txtracking.boundary;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class CallAudit {

    @AroundInvoke
    public Object onCall(InvocationContext ic) throws Exception{
        String method = ic.getMethod().toString();
        try{
            System.out.println("before " + method);
            return ic.proceed();
        }finally{
            System.out.println("after " + method);
        }
    }
}
