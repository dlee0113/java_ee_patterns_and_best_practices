package com.abien.wisdomator.business.security.boundary;

import com.abien.wisdomator.business.security.entity.Permission;
import com.abien.wisdomator.business.security.entity.User;
import java.lang.reflect.Method;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam-bien.com
 */
public class Guard {
    
    @Inject
    Instance<User> users;
    
    @AroundInvoke
    public Object validatePermissions(InvocationContext ic) throws Exception{
        Method method = ic.getMethod();
        User user = users.get();
        if(!isAllowed(method, user)){
            throw new SecurityException("User " + user + " is not allowed to execute the method " + method);
        }
        return ic.proceed();
    }

     boolean isAllowed(Method method,User u) {
        AllowedTo annotation = method.getAnnotation(AllowedTo.class);
        if(annotation == null) {
             return true;
         }
        Permission[] permissions = annotation.value();
         for (Permission permission : permissions) {
             if(u.isAllowed(permission)){
                 return true;
             }
         }
         return false;
     }
}
