package com.vegas.casino.presentation;

import com.vegas.casino.business.Casino;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Index {

    @EJB
    Casino casino;

    public String getHelloVegas(){
        return casino.getGame().toString();
    }

}
