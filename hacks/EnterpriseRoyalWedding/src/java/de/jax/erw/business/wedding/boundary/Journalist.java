package de.jax.erw.business.wedding.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Journalist {
    
    @AroundInvoke
    public Object writeJournal(InvocationContext ic) throws Exception{
        System.out.println("Bild: " +ic.getMethod());
        return ic.proceed();
    }
    
}
