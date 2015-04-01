package com.javaone.coolparts;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@DependsOn("LazyStarter")
@Singleton
public class StartMeUp {
    
    @Inject
    SadLegacy sl;
    
    @PostConstruct
    public void start(){
        System.out.println("---starte" );
    }
    
    
    @Schedule(minute="*",hour="*",second="*/1", persistent=false)
    public void invoke(){
        
        System.out.println("--- periodic: " + new Date() + sl.getMessage());
    }
}
