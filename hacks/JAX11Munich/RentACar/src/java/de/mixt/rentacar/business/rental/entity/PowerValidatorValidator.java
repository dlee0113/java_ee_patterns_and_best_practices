/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class PowerValidatorValidator implements ConstraintValidator<PowerValidator, Vehicle> {

    private PowerValidator powerValidator;
    
    @Override
    public void initialize(PowerValidator constraintAnnotation) {
        powerValidator = constraintAnnotation;
    }
    
    @Override
    public boolean isValid(Vehicle value, ConstraintValidatorContext context) {
        if("tesla".equalsIgnoreCase(value.getName()))
            return true;
        return false;
    }
}
