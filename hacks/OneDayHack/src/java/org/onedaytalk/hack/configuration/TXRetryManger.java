package org.onedaytalk.hack.configuration;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class TXRetryManger {
    
    @AroundInvoke
    public Object retry(InvocationContext ic) throws Exception{
        Object proceed = null;
        for(int i=0;i<5;i++){
          proceed  = ic.proceed();
        }
        return proceed;
    }
}
