package com.abien.patterns.aop.interceptors;

import com.abien.patterns.aop.Audit;
import static com.abien.patterns.aop.interceptors.Nice.Level.PERSONAL;
import java.lang.reflect.Method;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Nice(PERSONAL) @Interceptor
public class PersonalNicenessExtender {
    
    @Inject
    Audit audit;
    
    @AroundInvoke
    public Object decorate(InvocationContext ic) throws Exception{
        Method method = ic.getMethod();
        String name = method.getName();
        Object result = ic.proceed();
        audit.write("Decorating: " + method + " with result: " + result);
        if(name.equals("greet"))
            return "Good " +result;
        else
            return result + " !";
    }
}
