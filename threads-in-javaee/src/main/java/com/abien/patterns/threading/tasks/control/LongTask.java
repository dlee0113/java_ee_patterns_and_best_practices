package com.abien.patterns.threading.tasks.control;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class LongTask {
    
    @Asynchronous
    public Future<String> execute(){
        try {
            Thread.sleep(2000);
            System.out.print(".");
        } catch (InterruptedException ex) {  }
        return new AsyncResult<String>(""+System.currentTimeMillis());
    }
}
