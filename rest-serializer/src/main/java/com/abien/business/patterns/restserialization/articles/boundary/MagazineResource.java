package com.abien.business.patterns.restserialization.articles.boundary;

import com.abien.business.patterns.restserialization.articles.entity.Article;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.*;
import static com.abien.business.patterns.restserialization.ArticleMediaType.*;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Path("magazine")
@Stateless
public class MagazineResource {
    
    @GET
    @Produces({APPLICATION_XML,APPLICATION_JSON,SERIALIZATION_HESSIAN,SERIALIZATION_JAVA})
    public Article recent(){
        return new Article("Java EE rocks","use it","javaee hacking",new Date());
    }

    @POST
    @Consumes({APPLICATION_XML,APPLICATION_JSON,SERIALIZATION_HESSIAN,SERIALIZATION_JAVA})
    public void accept(Article article){
        System.out.println("Accepted: " + article);
    }
}
