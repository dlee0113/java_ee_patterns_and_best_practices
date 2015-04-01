/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.business.management.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class GovernmentAuditService {


    @AroundInvoke
    public Object monitorWeapons(InvocationContext context) throws Exception{
        System.out.println("Monitoring: " + context.getMethod());
        System.out.println("Monitoring: " + context.getTarget());
        return context.proceed();
    }
}
