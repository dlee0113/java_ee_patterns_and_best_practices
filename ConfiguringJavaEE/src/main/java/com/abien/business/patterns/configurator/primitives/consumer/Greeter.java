package com.abien.business.patterns.configurator.primitives.consumer;

import com.abien.business.patterns.configurator.primitives.provider.Configurable;
import com.abien.business.patterns.configurator.staging.StageDependent;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */

@Stateless
public class Greeter {
    
    @Inject @Configurable("greetings")
    private String message;

    @Inject @StageDependent
    private String stagedMessage;

    @Inject
    private int repetition;
    
    public String hello(){
     StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repetition; i++) {
            builder.append(message);
        }
        return builder.toString();
    }
    
    public String stagedMessage(){
        return stagedMessage;
    }
}
