package de.pizza42.business.order.boundary;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PizzaValidator.class)
public @interface Delicious {
    String message() default "Not very ghood!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}