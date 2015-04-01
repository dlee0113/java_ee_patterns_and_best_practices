package com.abien.patterns.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
@SLAAudit @Interceptor
public class SLAInterceptor {
    
    private static final Logger LOG = Logger.getLogger(SLAInterceptor.class.getName());
    
    @AroundInvoke
    public Object measurePerformance(InvocationContext context) throws Exception{
        long start = System.currentTimeMillis();
        try{
            return context.proceed();
        }finally{
            LOG.log(Level.INFO, "Method: {0} performed in {1}", new Object[]{context.getMethod(), System.currentTimeMillis() - start});
        }
    }
}
