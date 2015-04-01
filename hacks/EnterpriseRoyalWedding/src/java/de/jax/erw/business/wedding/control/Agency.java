package de.jax.erw.business.wedding.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Qualifier
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Agency {

    Factor value();
    
    enum Factor{
        NICE, STRANGE
    }
}
