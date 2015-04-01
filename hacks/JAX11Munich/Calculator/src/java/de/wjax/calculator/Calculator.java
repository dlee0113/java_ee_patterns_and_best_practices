/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import static de.wjax.calculator.Corrected.Level.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */

//@Interceptors(CalculationCorrectionSomething.class)
@Presenter
public class Calculator {

    @Inject
    BatchCalculator bc;
    
    public String result(){
        Future<String> result = bc.batchCompute("2*21");
        try {
            return result.get(2, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            throw new IllegalStateException("Cannot fix that  " + ex);
        } catch (ExecutionException ex) {
            throw new IllegalStateException(ex.getCause());
        } catch (TimeoutException ex) {
            throw new IllegalStateException("Cannot fix that  " + ex);
        }
    }
}

