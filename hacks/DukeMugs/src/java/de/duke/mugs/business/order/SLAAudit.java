/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.duke.mugs.business.order;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author blog.adam-bien.com
 */
public class SLAAudit {

    @AroundInvoke
    public Object performanceAuditor(InvocationContext context) throws Exception{
        long start = System.currentTimeMillis();
        try{
            System.out.println("Method: " + context.getMethod());
        return context.proceed();
        }finally{
            System.out.println("---- " + (System.currentTimeMillis() - start));
        }
    }

}
