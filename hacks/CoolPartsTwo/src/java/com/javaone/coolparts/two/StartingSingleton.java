package com.javaone.coolparts.two;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@DependsOn("ImportantService")
@Singleton
public class StartingSingleton {
    
    @Inject
    private int seconds;
    
    
    TimerService ts;
    
    @PostConstruct
    public void onStartOrRedeploy(){
        System.out.println(":::::::::::Strtin");
    
    }
    
    @Schedule(hour="*",minute="*",second="*/5",persistent=false)
    public void doSomethingPeriodically(){
        ScheduleExpression expression = new ScheduleExpression();
        expression.second(seconds);
        System.out.println("Did it: " + new Date() + " every: " + seconds);
    }
    
    @PreDestroy
    public void eveOfDestruction(){
        System.out.println("Destroy me!");
    }
}
