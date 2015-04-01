package com.abien.patterns.business.aspects.monitoring;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Monitorable
@Interceptor
public class PerformanceAudit {

    @AroundInvoke
    public Object measure(InvocationContext ic) throws Exception{
        long start = System.currentTimeMillis();
        Method method = ic.getMethod();
        try{
            return ic.proceed();
        }finally{
            System.out.println(method + " executed in: " + (System.currentTimeMillis() - start ) + " ms");
        }
    }
}
