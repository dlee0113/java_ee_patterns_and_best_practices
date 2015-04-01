/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.tuning.control;

import de.mixt.rentacar.business.rental.entity.Vehicle;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@CarType(CarType.Type.USUAL)
public class TireImprovement implements Tuner{

    @Override
    public void makeLookBetter(Vehicle vehicle) {
        System.out.println("--- Tires are broader!: " + vehicle);
    }
    
}
