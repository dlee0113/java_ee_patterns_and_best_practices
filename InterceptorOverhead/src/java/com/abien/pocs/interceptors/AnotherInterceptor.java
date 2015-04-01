package com.abien.pocs.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class AnotherInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception{
        return ic.proceed();
    }
}
