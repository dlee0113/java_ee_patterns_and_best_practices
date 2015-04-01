package com.abien.business.patterns.bridgeplugin.serializers;

import com.abien.business.patterns.bridgeplugin.Standard;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Standard
public class JavaSerializer implements Serializer {

    public byte[] serialize(Serializable object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(object);
            out.flush();
        } catch (IOException iOException) {
            throw new RuntimeException("Cannot serialize: " + object, iOException);
        }
        return baos.toByteArray();
    }
}
