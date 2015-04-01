package com.abien.smokingservers.business.smoke.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class SmokeDetector {


    @AroundInvoke
    public Object detectSmoke(InvocationContext ic) throws Exception{
        System.out.println("Method: " + ic.getMethod());
        return ic.proceed();
    }
}
