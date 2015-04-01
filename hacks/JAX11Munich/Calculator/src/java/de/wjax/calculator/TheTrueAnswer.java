/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Interceptor @Corrected(Corrected.Level.REAL)
public class TheTrueAnswer {
    
    @AroundInvoke
    public Object correct(InvocationContext context) throws Exception{
        return "The true Result is: " + context.proceed();
    }

}
