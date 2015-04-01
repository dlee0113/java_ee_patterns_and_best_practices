package com.abien.business.patterns.restserialization;

import com.abien.business.patterns.restserialization.articles.entity.Article;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class HessianDeserializerTest {
    
    HessianDeserializer cut;
    
    @Before
    public void init(){
        cut = new HessianDeserializer();
    }

    @Test
    public void isReadable() {
        assertTrue(cut.isReadable(Article.class, null, null, MediaType.WILDCARD_TYPE));
        assertFalse(cut.isReadable(Object.class, null, null, MediaType.WILDCARD_TYPE));
    }

}
