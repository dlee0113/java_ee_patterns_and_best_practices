package com.abien.business.patterns.bridgeplugin.deserializers;

import com.abien.business.patterns.bridgeplugin.Standard;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Standard
public class JavaDeserializer implements Deserializer {

    @Override
    public Serializable deserialize(byte[] content) {
       ByteArrayInputStream bais = new ByteArrayInputStream(content);
        try {
            ObjectInputStream hsi = new ObjectInputStream(bais);
            return (Serializable) hsi.readObject();
        } catch (Exception ex) {
            throw new RuntimeException("Cannot deserialize object: " + ex,ex);
        }
    }
}
