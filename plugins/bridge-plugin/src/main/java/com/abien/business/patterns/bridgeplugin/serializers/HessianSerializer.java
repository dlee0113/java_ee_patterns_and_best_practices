package com.abien.business.patterns.bridgeplugin.serializers;

import com.abien.business.patterns.bridgeplugin.Optimized;
import com.caucho.hessian.io.Hessian2StreamingOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Optimized
public class HessianSerializer implements Serializer {

    @Override
    public byte[] serialize(Serializable object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2StreamingOutput out = new Hessian2StreamingOutput(baos);
        try {
            out.writeObject(object);
            out.flush();
        } catch (IOException iOException) {
            throw new RuntimeException("Cannot serialize: " + object,iOException);
        }
        return baos.toByteArray();
    }

    
}
