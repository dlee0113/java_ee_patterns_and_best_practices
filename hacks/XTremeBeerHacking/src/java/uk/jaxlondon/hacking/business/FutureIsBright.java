/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author abien
 */
@Stateless
public class FutureIsBright {
    
    @Asynchronous
    public Future<String> causeException(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FutureIsBright.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new IllegalStateException("There is no future for ...");
        //return new AsyncResult<String>(42);
    }
    
}
