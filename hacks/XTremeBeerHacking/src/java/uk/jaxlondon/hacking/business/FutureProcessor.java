/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import java.util.concurrent.Future;
import javax.enterprise.event.Observes;

/**
 *
 * @author abien
 */
public class FutureProcessor {
    
    
    public void onFuture(@Observes Future myFuture){
        System.out.println("Got future!");
    }
}
