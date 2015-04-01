package com.abien.business.patterns.restserialization;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2StreamingInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Provider
@Consumes(ArticleMediaType.SERIALIZATION_HESSIAN)
public class HessianDeserializer implements MessageBodyReader<Object> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Serializable.class.isAssignableFrom(type);
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        Hessian2StreamingInput in = new Hessian2StreamingInput(entityStream);
        return in.readObject();
    }
}
