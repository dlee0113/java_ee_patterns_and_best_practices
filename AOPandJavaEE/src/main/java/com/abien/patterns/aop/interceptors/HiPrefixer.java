package com.abien.patterns.aop.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Hi @Interceptor
public class HiPrefixer {
    
    @AroundInvoke
    public Object decorate(InvocationContext ic) throws Exception{
        return "Hi, "+ ic.proceed();
    }
}
