package com.abien.patterns.business.boundarypattern.bookstore.boundary;

import com.abien.patterns.business.boundarypattern.bookstore.entity.Book;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
@Path("orders")
public class OrdersResource {

    @Inject
    BookOrdering ordering;
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response order(Book order){
        ordering.order(order);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
