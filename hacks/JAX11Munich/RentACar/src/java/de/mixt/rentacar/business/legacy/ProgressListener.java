/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.legacy;

import de.mixt.rentacar.business.rental.entity.Vehicle;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class ProgressListener {
    
    public void onReportedVehicle(@Observes(during= TransactionPhase.AFTER_SUCCESS) Vehicle vehicle){
        System.out.println("-GOT event-- " + vehicle);
    }

    public void onFailedVehicle(@Observes(during= TransactionPhase.AFTER_FAILURE) Vehicle vehicle){
        System.out.println("-GOT a rolled back-- " + vehicle);
    }
    
}
