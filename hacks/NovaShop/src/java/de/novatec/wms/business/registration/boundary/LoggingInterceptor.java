/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.novatec.wms.business.registration.boundary;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author blog.adam-bien.com
 */
public class LoggingInterceptor {

    @Resource
    SessionContext sc;

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception{
        System.out.println("---------- " + ic.getMethod() + " " + sc.getCallerPrincipal());
        return ic.proceed();
    }
}
