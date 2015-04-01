package com.abien.patterns.threading.tasks.boundary;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.*;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PersistentAsynchronous {
    
    @Resource
    TimerService ts;
    
    public void executeAsync(String message){
        TimerConfig config = new TimerConfig(message, true);
        ts.createSingleActionTimer(1, config);
    }
    
    @Timeout
    public void execute(Timer timer){
        System.out.println("--- Done! Method executed! " + new Date() + " " + timer.getInfo());
    }
}
