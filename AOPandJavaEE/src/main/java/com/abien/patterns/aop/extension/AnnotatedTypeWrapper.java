package com.abien.patterns.aop.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.inject.spi.AnnotatedType;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class AnnotatedTypeWrapper implements AnnotatedType{
    private AnnotatedType annotatedType;
    
    private Set<Annotation> annotations;

    public AnnotatedTypeWrapper(AnnotatedType annotatedType) {
        this.annotatedType = annotatedType;
        this.annotations = new HashSet<Annotation>();
    }
    
    public void addAnnotation(Annotation annotation){
        this.annotations.add(annotation);
    }

    public boolean isAnnotationPresent(Class<? extends Annotation> type) {
        return annotatedType.isAnnotationPresent(type);
    }

    public Set<Type> getTypeClosure() {
        return annotatedType.getTypeClosure();
    }

    public Type getBaseType() {
        return annotatedType.getBaseType();
    }

    public Set<Annotation> getAnnotations() {
        annotations.addAll(annotatedType.getAnnotations());
        return annotations;
    }

    public <T extends Annotation> T getAnnotation(Class<T> type) {
        return annotatedType.getAnnotation(type);
    }

    public Set getMethods() {
        return annotatedType.getMethods();
    }

    public Class getJavaClass() {
        return annotatedType.getJavaClass();
    }

    public Set getFields() {
        return annotatedType.getFields();
    }

    public Set getConstructors() {
        return annotatedType.getConstructors();
    }

    
    
}
