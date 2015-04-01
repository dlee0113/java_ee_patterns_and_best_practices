/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.boundary;

import de.mixt.rentacar.business.rental.control.Auditor;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class AuditorAspect {
    
    @Inject
    Auditor auditor;
    
    @AroundInvoke
    public Object audit(InvocationContext ic) throws Exception{
        Method method = ic.getMethod();
        auditor.audit("AUDIT: " + method);
        return ic.proceed();
    }
    
}
