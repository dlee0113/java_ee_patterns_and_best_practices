package de.twitterng.business.messaging.boundary;

import java.lang.reflect.Field;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Configurator {

    @AroundInvoke
    public Object configure(InvocationContext ctx) throws Exception{
        String fqn = ctx.getTarget().getClass().getName();
        Field[] declaredFields = ctx.getTarget().getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(fqn +  field.getName());
        }
        
       return ctx.proceed();
    }
}
