/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Corrected(Corrected.Level.SEMI)
@Model
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Presenter {
    
}
