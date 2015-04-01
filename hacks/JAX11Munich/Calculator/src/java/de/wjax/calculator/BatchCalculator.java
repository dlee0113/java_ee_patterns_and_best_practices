package de.wjax.calculator;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Stateless
public class BatchCalculator {
    
    @Inject
    Event<String> result;

    @Asynchronous
    public Future<String> batchCompute(String formula){
       String retVal = "Result: " + formula;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BatchCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        result.fire(retVal);
        return new AsyncResult<String>(retVal);
    }
    
}
