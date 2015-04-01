package org.onedaytalk.hack.configuration;

import javax.enterprise.event.Observes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class EnterpriseAdmin {
    
    
    public void onImportantConfig(@Observes @Importance(Importance.Level.HIGH) String msg){
        System.out.println("Important: " + msg);
    }
    
}
