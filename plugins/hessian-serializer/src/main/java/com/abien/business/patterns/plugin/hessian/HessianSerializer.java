package com.abien.business.patterns.plugin.hessian;

import com.abien.business.patterns.plugin.serializer.Serialization;
import com.abien.business.patterns.plugin.serializer.Serializer;
import com.caucho.hessian.io.Hessian2StreamingOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;



/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Serialization(Serialization.Type.OPTIMIZED)
public class HessianSerializer implements Serializer {

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
