/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.rental.boundary;

import de.mixt.rentacar.business.tuning.control.CarType;
import java.lang.annotation.Annotation;
import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class TuningSelector implements CarType {

    private Type type;

    public TuningSelector(Type type) {
        this.type = type;
    }
    
    
    
    @Override
    public Type value() {
        return this.type;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return CarType.class;
    }
    
    
}
