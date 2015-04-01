/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

import java.util.Date;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author abien
 */
@Stateless
public class WakeUpTimeCalculator {
    
    @Asynchronous
    public Future<Date> compute(){
        Date d = new Date();
        
        return new AsyncResult<Date>(d);
    }
}
