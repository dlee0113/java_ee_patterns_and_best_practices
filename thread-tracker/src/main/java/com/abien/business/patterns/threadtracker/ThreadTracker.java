package com.abien.business.patterns.threadtracker;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, adam-bien.com
 */
@Interceptor @Monitorable
public class ThreadTracker {

    @AroundInvoke
    public Object annotateThread(InvocationContext invCtx) throws Exception {
        String originName = Thread.currentThread().getName();
        String beanName = invCtx.getTarget().getClass().getName();
        String tracingName = beanName + "#" + invCtx.getMethod().getName() + " " + originName;
        try {
            Thread.currentThread().setName(tracingName);
            return invCtx.proceed();
        } finally {
            System.out.println("After invocation: " + tracingName);
            Thread.currentThread().setName(originName);
        }
    }
}
