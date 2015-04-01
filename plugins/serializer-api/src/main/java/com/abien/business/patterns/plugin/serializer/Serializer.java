package com.abien.business.patterns.plugin.serializer;

import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public interface Serializer {
    public byte[] serialize(Serializable object);
}
