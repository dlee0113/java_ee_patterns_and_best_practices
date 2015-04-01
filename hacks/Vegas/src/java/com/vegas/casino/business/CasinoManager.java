/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vegas.casino.business;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class CasinoManager {

    @AroundInvoke
    public Object track(InvocationContext ic) throws Exception{
        System.out.println("Invoked! " + ic.getMethod());
        return ic.proceed();
    }

}
