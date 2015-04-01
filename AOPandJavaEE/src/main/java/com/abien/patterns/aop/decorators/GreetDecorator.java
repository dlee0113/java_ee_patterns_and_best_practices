package com.abien.patterns.aop.decorators;

import com.abien.patterns.aop.Greeter;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */

@Decorator
public abstract class GreetDecorator implements Greeter{
    @Inject @Delegate
    Greeter greeter;
    
    @Override
    public String greet() {
        return "Good (decorated) " + greeter.greet();
    }
}
