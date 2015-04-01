package de.berlin.dojorn.business.tasks.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class TaskAuditor {

    @AroundInvoke
    public Object audit(InvocationContext ctx) throws Exception {
        System.out.println("---- " + ctx.getMethod());
        long start = System.currentTimeMillis();
        try {
            return ctx.proceed();
        } finally {
            System.out.println("Invoked in " + (System.currentTimeMillis() - start));
        }
    }
}
