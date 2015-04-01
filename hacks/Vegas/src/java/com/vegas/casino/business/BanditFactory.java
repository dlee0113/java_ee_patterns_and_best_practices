package com.vegas.casino.business;

import javax.enterprise.inject.Produces;


public class BanditFactory {


    @Produces
    public Bandit create(){
        return new Bandit("from factory");
    }
}
