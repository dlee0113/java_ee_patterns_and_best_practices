package org.onedaytalk.hack.configuration;

import java.lang.annotation.Annotation;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class ChannelSelector implements Importance{
   
    Level level;

    public ChannelSelector(Level level) {
        this.level = level;
    }
    
    

    @Override
    public Level value() {
        return level;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        
        return Importance.class;
    }
    
}
