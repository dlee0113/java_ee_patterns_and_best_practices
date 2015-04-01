package com.abien.patterns.aop.interceptors;

import static com.abien.patterns.aop.interceptors.Nice.Level.USUAL;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Nice(USUAL) @Interceptor
public class NicenessExtender {
    
    @AroundInvoke
    public Object decorate(InvocationContext ic) throws Exception{
        return "Good "+ ic.proceed();
    }
}
