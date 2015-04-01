package com.abien.business.patterns.plugin.testapp.boundary;

import com.abien.business.patterns.plugin.serializer.Serializer;
import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class NullSerializer implements Serializer{

    public byte[] serialize(Serializable object) {
        return new byte[0];
    }
    
    
}
