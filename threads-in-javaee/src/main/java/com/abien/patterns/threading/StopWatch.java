package com.abien.patterns.threading;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class StopWatch {

    @AroundInvoke
    public Object measure(InvocationContext ic) throws Exception {
        String retVal = null;
        long start = System.currentTimeMillis();
        try {
            retVal = (String) ic.proceed();
        } finally {
            retVal += (System.currentTimeMillis() - start + " ms");
        }
        return retVal;
    }
}
