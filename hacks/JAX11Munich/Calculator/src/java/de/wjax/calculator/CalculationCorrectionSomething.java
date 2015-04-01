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
@Interceptor @Corrected(Corrected.Level.SEMI)
public class CalculationCorrectionSomething {
    
    @AroundInvoke
    public Object correct(InvocationContext context) throws Exception{
        return "Result is: " + context.proceed();
    }
    
}
