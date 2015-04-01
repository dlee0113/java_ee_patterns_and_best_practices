package com.abien.nointerfaces.control;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class CommunicationSniffer {
    
    @AroundInvoke
    public Object sniff(InvocationContext ic) throws Exception{
        Object result = ic.proceed();
        System.out.printf("Method %s returned %s",ic.getMethod(),result);
        return result;
    }
}
