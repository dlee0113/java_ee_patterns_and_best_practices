/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author abien
 */
public class IsDukeValidator implements ConstraintValidator<IsDuke, Call> {
    private IsDuke annotation;
    
    @Override
    public void initialize(IsDuke constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }
    
    @Override
    public boolean isValid(Call value, ConstraintValidatorContext context) {
        String name = value.getName();
        long time = value.getTime();
        if("duke".equalsIgnoreCase(name)){
            return time == this.annotation.expectedNumber();
        }
        return false;
    }
}
