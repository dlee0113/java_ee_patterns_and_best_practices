/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author abien
 */
public class CallAudit {
    
    @AroundInvoke
    public Object auditCall(InvocationContext ic) throws Exception{
        System.out.println("--- " + ic.getMethod());
        return ic.proceed();
    }
}
