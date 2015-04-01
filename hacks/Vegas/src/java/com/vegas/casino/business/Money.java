/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vegas.casino.business;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface Money {

    Amount value();

    enum Amount{
        LOT, LITTLE
    }

}
