package de.pizza42.business.order.boundary;

import de.pizza42.business.order.entity.Pizza;
import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author blog.adam-bien.com
 */
public class PizzaValidator implements ConstraintValidator<Delicious, String>{

    private Delicious delicious;

    @Override
    public void initialize(Delicious constraintAnnotation) {
        this.delicious = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equalsIgnoreCase("duke"))
            return true;
        else
            return false;
    }

}
