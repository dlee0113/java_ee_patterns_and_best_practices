package de.twitterng.business.messaging.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Auditor {
    
    @AroundTimeout
    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception{
       long start = System.currentTimeMillis();
       try{ 
        return context.proceed(); 
       }finally{
           System.out.println("Performance: " + context.getMethod() +  (System.currentTimeMillis() - start));
       }
    }

}
