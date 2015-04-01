/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien.business.patterns.restserialization;

import com.abien.business.patterns.restserialization.articles.entity.Article;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2StreamingInput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class HessianSerializerTest {
    
    HessianSerializer cut;
    
    @Before
    public void init(){
        cut = new HessianSerializer();
    }
    
    @Test
    public void isWriteable() {
        assertTrue(cut.isWriteable(Article.class, null, null, MediaType.WILDCARD_TYPE));
        assertFalse(cut.isWriteable(Object.class, null, null, MediaType.WILDCARD_TYPE));
    }
    
    @Test
    public void serialize() throws Exception{
        String expected = "Hey Duke!";
        ByteArrayOutputStream bois = new ByteArrayOutputStream();
        cut.writeTo(expected, null, null, null, MediaType.WILDCARD_TYPE, null, bois);

        final byte[] content = bois.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        Hessian2StreamingInput inputStream = new Hessian2StreamingInput(bais);
        String actual = (String) inputStream.readObject();
        assertThat(actual,is(expected));
    }
}
