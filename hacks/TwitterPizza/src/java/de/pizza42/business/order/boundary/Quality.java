/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pizza42.business.order.boundary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author blog.adam-bien.com
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface Quality {
    Level value();
    enum Level{
        DELICIOUS, GUM
    }

}
