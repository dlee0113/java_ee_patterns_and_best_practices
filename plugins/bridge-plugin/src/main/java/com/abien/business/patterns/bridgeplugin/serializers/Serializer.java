package com.abien.business.patterns.bridgeplugin.serializers;

import java.io.Serializable;

/**
 *
 * @author adam bien, adam-bien.com
 */
public interface Serializer {

    public byte[] serialize(Serializable serializable);
}
