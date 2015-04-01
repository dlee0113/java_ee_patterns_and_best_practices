/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wjax.calculator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@InterceptorBinding
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Corrected {
    
    Level value();
    
    enum Level{
        SEMI,REAL
    }
    
}
