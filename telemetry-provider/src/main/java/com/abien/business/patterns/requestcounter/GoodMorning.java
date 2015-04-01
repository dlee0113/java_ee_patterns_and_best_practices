package com.abien.business.patterns.requestcounter;

import com.abien.business.patterns.telemetryprovider.PerformanceAuditor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author adam-bien.com
 */
@Interceptors(PerformanceAuditor.class)
@Stateless
public class GoodMorning {
    
    public void say(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoodMorning.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tooEarly(){
        throw new IllegalStateException("Too early for good morning!");
    }
}
