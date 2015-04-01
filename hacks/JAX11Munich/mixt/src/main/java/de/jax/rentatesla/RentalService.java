/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jax.rentatesla;

import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class RentalService {
    
    @Inject
    CustomerValidation cv;
    
    
    public boolean buy(String vehicleId){
        if(cv.cashAmount(43)){
            return true;
        }
        throw new IllegalArgumentException("Poor customer exception");
    }
    
    
}
