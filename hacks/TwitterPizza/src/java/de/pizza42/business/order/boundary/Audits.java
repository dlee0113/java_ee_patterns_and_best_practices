package de.pizza42.business.order.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author blog.adam-bien.com
 */
public class Audits {

    @AroundInvoke
    public Object logPerformance(InvocationContext context) throws Exception{
          System.out.println("--- " + context.getMethod());
          return context.proceed();
    }
}
