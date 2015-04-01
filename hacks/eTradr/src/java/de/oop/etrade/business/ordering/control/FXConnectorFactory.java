package de.oop.etrade.business.ordering.control;

import javax.enterprise.inject.Produces;

public class FXConnectorFactory {


    //@Produces
    public FXConnect connect(){
        return new FXConnect(80);
    }
}
