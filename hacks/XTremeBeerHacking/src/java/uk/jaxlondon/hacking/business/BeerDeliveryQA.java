/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author abien
 */
public class BeerDeliveryQA {
    
    @AroundInvoke
    public Object isRightQuality(InvocationContext ic) throws Exception{
        System.out.println("Method properly invoked: " + ic.getMethod());
        for(int i=0;i<5;i++)
            ic.proceed();
        return "Empty bottle exception";
    }
    
}
