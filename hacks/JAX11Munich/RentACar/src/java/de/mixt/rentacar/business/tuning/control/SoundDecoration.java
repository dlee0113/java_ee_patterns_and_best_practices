package de.mixt.rentacar.business.tuning.control;

import de.mixt.rentacar.business.rental.entity.Vehicle;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@CarType(CarType.Type.ECAR)
public class SoundDecoration implements Tuner{

    @Override
    public void makeLookBetter(Vehicle vehicle) {
        System.out.println("--- tesla sounds like ferrari: " + vehicle);
    }
    
}
