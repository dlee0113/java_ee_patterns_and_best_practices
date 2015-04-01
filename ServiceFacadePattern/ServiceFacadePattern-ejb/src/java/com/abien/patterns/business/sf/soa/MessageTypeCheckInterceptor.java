package com.abien.patterns.business.sf.soa;

import java.lang.reflect.Method;
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
public class MessageTypeCheckInterceptor {
    
    @AroundInvoke
    public Object audit(InvocationContext invocationContext) throws Exception{
        Method method = invocationContext.getMethod();
        if("onMessage".equals(method.getName())){
            ExpectedMessageType messageType = method.getAnnotation(ExpectedMessageType.class);
            Class expectedType = messageType.value();
            Object messageParameter = messageParameter(invocationContext);
            if(!expectedType.isAssignableFrom(messageParameter.getClass())){
                escalateError(expectedType,messageParameter);
            }
        }
                System.out.println("Method invoked: " + method);
                return invocationContext.proceed();
    }

    private void escalateError(Class expectedType, Object messageParameter) {
        throw new IllegalStateException("The expected type of the message was: " + expectedType + " and is: " + messageParameter.getClass().getName() + " Payload" + messageParameter);
    }
    
    private Object messageParameter(InvocationContext context){
        return context.getParameters()[0];
    }

}
