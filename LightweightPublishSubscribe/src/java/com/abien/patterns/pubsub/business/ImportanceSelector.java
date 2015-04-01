package com.abien.patterns.pubsub.business;

import java.lang.annotation.Annotation;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class ImportanceSelector implements Importance{

    private Importance.Degree degree;

    public ImportanceSelector(Importance.Degree importance) {
        this.degree = importance;
    }
    
    @Override
    public Degree value() {
        return degree;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Importance.class;
    }
    
}
