/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.oop.etrade.business.ordering.control;

import com.sun.jersey.api.client.Client;
import de.oop.etrade.business.ordering.entity.Stock;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author blog.adam-bien.com
 */
public class StockClient {

    public static void main(String[] args) {
        Client create = Client.create();
        Stock stock = create.resource("http://localhost:8080/eTradr/resources/stocks").
                accept(MediaType.APPLICATION_XML).
                get(Stock.class);
        System.out.println("Stock: " + stock);
    }

}
