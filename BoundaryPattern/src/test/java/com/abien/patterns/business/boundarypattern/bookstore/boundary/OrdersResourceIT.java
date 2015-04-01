package com.abien.patterns.business.boundarypattern.bookstore.boundary;

import com.abien.patterns.business.boundarypattern.bookstore.entity.Book;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class OrdersResourceIT {
    private WebResource.Builder ordersResource;
    
    @Before
    public void initialize(){
        Client client = Client.create();
        this.ordersResource = client.resource("http://localhost:8080/BoundaryPattern/resources/orders").accept(MediaType.APPLICATION_XML);
    }

    @Test
    public void orderInvalidBook() {
        Book book = new Book("1", "Java EE Night Hacks");
        this.ordersResource.put(book);
    }

    @Test
    public void orderValidBook() {
        Book book = new Book("123", "Java EE Night Hacks");
        this.ordersResource.put(book);
    }
}
