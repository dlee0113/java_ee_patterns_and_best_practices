package de.javaeesummit.hotel.boundary;

import de.javaeesummit.hotel.control.GuestValidation;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class RegistrationService {
    
    @Inject
    GuestValidation gv;
    
    public boolean registered(){
        if(gv.checkWithFBI() == 42)
            return true;
        else
            throw new IllegalStateException("Suspicious guest!!!");
    }
    
}
