package com.abien.business.patterns.restserialization.monitoring.boundary;

import com.abien.business.patterns.restserialization.ArticleMediaType;
import com.abien.business.patterns.restserialization.HessianDeserializer;
import com.abien.business.patterns.restserialization.HessianSerializer;
import com.abien.business.patterns.restserialization.JavaDeserializer;
import com.abien.business.patterns.restserialization.JavaSerializer;
import com.abien.business.patterns.restserialization.articles.entity.Article;
import static javax.ws.rs.client.Entity.entity;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ClientFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Configuration;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class MagazineResourceIT {
    private static String RESOURCE_URI = "http://localhost:8080/rest-serializer/resources/magazine";
    private Client client;
    private Target target;
    
    @Before
    public void init(){
        this.client = ClientFactory.newClient();
        final Configuration configuration = client.configuration();
        configuration.register(HessianDeserializer.class);
        configuration.register(HessianSerializer.class);
        configuration.register(JavaSerializer.class);
        configuration.register(JavaDeserializer.class);
        this.target = this.client.target(RESOURCE_URI);
    }
    
    @Test
    public void crudWithHessian() throws Exception {
        crud(ArticleMediaType.SERIALIZATION_HESSIAN);
    }

    @Test
    public void crudWithJavaSerialization() throws Exception {
        crud(ArticleMediaType.SERIALIZATION_JAVA);
    }

    @Test
    public void crudWithXML() throws Exception {
        crud(MediaType.APPLICATION_XML);
    }
    public void crud(String mediaType) throws Exception {
        Article article = this.target.request(mediaType).get(Article.class);
        assertNotNull(article);
        this.target.request().post(entity(article,mediaType));
    }
}
