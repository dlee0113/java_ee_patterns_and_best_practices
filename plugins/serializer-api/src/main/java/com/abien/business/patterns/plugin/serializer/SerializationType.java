package com.abien.business.patterns.plugin.serializer;

import javax.enterprise.util.AnnotationLiteral;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class SerializationType extends AnnotationLiteral<Serialization> implements Serialization{

    Type type;

    public SerializationType(Type type) {
        this.type = type;
    }
    
    @Override
    public Type value() {
        return type;
    }
    
}
