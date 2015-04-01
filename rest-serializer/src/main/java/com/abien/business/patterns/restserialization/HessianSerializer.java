package com.abien.business.patterns.restserialization;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.Hessian2StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Provider
@Produces(ArticleMediaType.SERIALIZATION_HESSIAN)
public class HessianSerializer implements MessageBodyWriter<Object> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Serializable.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Object t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        Hessian2StreamingOutput out = new Hessian2StreamingOutput(entityStream);
        out.writeObject(t);
        out.flush();
    }
}
