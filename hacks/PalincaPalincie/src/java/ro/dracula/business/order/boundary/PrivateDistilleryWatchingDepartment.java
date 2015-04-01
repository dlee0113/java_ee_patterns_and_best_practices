package ro.dracula.business.order.boundary;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class PrivateDistilleryWatchingDepartment {

    @AroundInvoke
    public Object checkPalincie(InvocationContext ic) throws Exception{
        System.out.println("Quality of: " + ic.getMethod()  + " is o.k !");
        return ic.proceed();
    }
}
