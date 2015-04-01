/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author abien
 */
@Constraint(validatedBy = IsDukeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDuke {
    int expectedNumber();
    
    String message() default "You are not duke";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
