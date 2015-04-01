/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Constraint(validatedBy = PowerValidatorValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PowerValidator {

    String message() default "You need more power";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
