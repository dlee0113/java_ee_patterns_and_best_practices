/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.twitterng.presentation.messaging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Stereotype
@Named
@RequestScoped

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Presenter {

}
