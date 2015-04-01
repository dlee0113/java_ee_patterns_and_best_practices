/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.marketing.control;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Startup
@Singleton
public class DynamicScheduler {

    @Resource
    TimerService service;

    private Timer timer;
    
    @PostConstruct
    public void loadFromDB(){
        System.out.println("--- loaded from DB3");
        
        ScheduleExpression expression = new ScheduleExpression();
        expression.hour("*").minute("*").second("*/2");
       // this.timer = service.createCalendarTimer(expression);
    }
    
    @Timeout
    public void executePeriodically(){
        
        System.out.println("-Periodically--  " + new Date());
    }
    
}
