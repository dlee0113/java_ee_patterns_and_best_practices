package de.pizza42.business.order.control;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CourierService {

    private AtomicLong pizzaCounter = new AtomicLong(0);

    @Asynchronous
    public Future<String> deliver(String pizza){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            //cannot sleep
        }
        System.out.println("Delivered: " + pizza);
        pizzaCounter.incrementAndGet();
        return new AsyncResult<String>("Ready");
    }
}
