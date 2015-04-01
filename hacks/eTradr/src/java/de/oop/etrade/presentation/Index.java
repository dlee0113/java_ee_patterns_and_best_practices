package de.oop.etrade.presentation;

import de.oop.etrade.business.ordering.boundary.QuoteService;
import de.oop.etrade.business.ordering.entity.Stock;
import javax.ejb.EJB;


@Presenter
public class Index {

    @EJB
    QuoteService service;

    private Stock stock = new Stock();


    public Stock getStock() {
        return stock;
    }

    public Object saveQuote(){
        service.updateQuote(stock);
        return null;
    }

    public String getTrade() {
        return "Trade: 42.0";
    }
}
