package com.abien.business.patterns.bridgeplugin.deserializers;

import java.io.Serializable;

/**
 *
 * @author adam bien, adam-bien.com
 */
public interface Deserializer {

    public Serializable deserialize(byte[] content);
}
