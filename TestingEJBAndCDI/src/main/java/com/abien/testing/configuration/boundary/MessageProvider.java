package com.abien.testing.configuration.boundary;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Singleton
public class MessageProvider {
    public static final String NO_CONSULTANT_ERROR = "No consultant to ask!";
    public static final String JAVA_IS_DEAD_MESSAGE = "Please perform a sanity / reality check";
    
    private Map<String,String> defaults;
    
    @PostConstruct
    public void populateDefaults(){
        this.defaults = new HashMap<String, String>(){{
            put("javaIsDeadError", JAVA_IS_DEAD_MESSAGE);
            put("noConsultantError", NO_CONSULTANT_ERROR);
        }};
    }
    
    @Produces
    public String getString(InjectionPoint ip){
        String key = ip.getMember().getName();
        return defaults.get(key);
    }
}
