/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.presentation;

import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import uk.jaxlondon.hacking.business.BeerDeliveryService;
import uk.jaxlondon.hacking.business.Bottle;

/**
 *
 * @author abien
 */
@Model
public class Index {
    
    @Inject
    BeerDeliveryService bds;
    
    @Inject
    Validator validator;

    
    Bottle bottle = new Bottle();

    @PostConstruct
    public void onCreate(){
        System.out.println("Created !");
    }
    
    
    public Bottle getBottle() {
        return bottle;
    }
    
    
    public String getBeer(){
        return bds.getBeer();
    }
    
    public Object save(){
        Set<ConstraintViolation<Bottle>> violations = validator.validate(this.bottle, new Class[]{});
        if(!violations.isEmpty())
            return "popup";
        System.out.println("Bottle is saved! " + bottle);
        bds.save(bottle);
        return null;
    }
}
