package de.oop.etrade.business.ordering.control;

import de.oop.etrade.business.ordering.entity.Stock;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AccessTimeout;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class StockCache {


    private CopyOnWriteArrayList<Stock> latest = new CopyOnWriteArrayList<Stock>();

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<String> onNewStock(@Observes Stock stock){
        try {
            latest.add(stock);
            System.out.println("Stock added " + stock);
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StockCache.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<String>("42");
    }



    @Schedule(second="*/5",hour="*",minute="*")
    public void emailLatestStocks(){
        for (Stock stock : latest) {
            System.out.println("Stock: " + stock);
        }
        System.out.println("Delivered " + latest.size());
        latest.clear();
    }


}
