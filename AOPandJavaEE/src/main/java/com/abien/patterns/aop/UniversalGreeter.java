package com.abien.patterns.aop;

import com.abien.patterns.aop.interceptors.LifecycleListener;
import javax.interceptor.Interceptors;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@NicePresenter
@Interceptors(LifecycleListener.class)
public class UniversalGreeter implements Greeter {
    
    @Override
    public String greet(){
        return "Morning";
    }
    
    @Override
    public String hello(){
        return "hello";
    }
}
