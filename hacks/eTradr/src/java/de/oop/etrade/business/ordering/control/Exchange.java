package de.oop.etrade.business.ordering.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
public @interface Exchange {

    Location value();
    
    enum Location{
        MUC,FRA
    }
}
