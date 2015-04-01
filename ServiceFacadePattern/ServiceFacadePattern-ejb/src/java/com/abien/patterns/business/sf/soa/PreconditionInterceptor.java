package com.abien.patterns.business.sf.soa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

* Copyright (c) 16. June 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
public class PreconditionInterceptor {
    
    @AroundInvoke
    public Object checkParameters(InvocationContext invocationContext) throws Exception{
        List<String> invalidParameters = invalidParameters(invocationContext);
        if(!invalidParameters.isEmpty()){
            Method method = invocationContext.getMethod();
            escalateError(method,invalidParameters);
           throw new IllegalArgumentException("The contract of the method: " + method + " was violated!");
        }else{
            return invocationContext.proceed();
        }
    }
    
    private List<String> invalidParameters(InvocationContext context){
        List<String> invalidParameters = new ArrayList<String>();
        Annotation[][] parameterAnnotations = context.getMethod().getParameterAnnotations();
        for (int i=0;i<parameterAnnotations.length;i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if(annotation instanceof NotNull){
                    Object value = context.getParameters()[i];
                    if(value == null){
                        Class parameterType =   context.getMethod().getParameterTypes()[i];
                        invalidParameters.add(i+ " parameter of type " + parameterType.getName() + " is null!");
                    }
                }
            }
        }
        return invalidParameters;
    }

    private void escalateError(Method method,List<String> invalidParameters) {
        System.out.println("Method: " + method);
        for (String string : invalidParameters) {
            System.out.println(string);
        }
    }
}
