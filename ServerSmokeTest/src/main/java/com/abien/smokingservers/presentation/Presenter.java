/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abien.smokingservers.presentation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stereotype
@RequestScoped
@Named
@Retention(RUNTIME)
@Target({TYPE})
public @interface Presenter {

}