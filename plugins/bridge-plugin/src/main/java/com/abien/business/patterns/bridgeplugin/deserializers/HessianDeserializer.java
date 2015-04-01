package com.abien.business.patterns.bridgeplugin.deserializers;

import com.abien.business.patterns.bridgeplugin.Optimized;
import com.caucho.hessian.io.Hessian2StreamingInput;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Optimized
public class HessianDeserializer implements Deserializer {

    @Override
    public Serializable deserialize(byte[] content) {
       ByteArrayInputStream bais = new ByteArrayInputStream(content);
       Hessian2StreamingInput hsi = new Hessian2StreamingInput(bais);
        try {
            return (Serializable) hsi.readObject();
        } catch (IOException ex) {
            throw new RuntimeException("Cannot deserialize object: " + ex,ex);
        }
    }
}
