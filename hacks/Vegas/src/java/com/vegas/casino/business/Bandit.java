package com.vegas.casino.business;

/**
 *
 * @author blog.adam-bien.com
 */
public class Bandit implements IBandit{

    private String message;

    public Bandit(String message) {
        this.message = message;
    }

    

    public void stealSomething(){
        System.out.println("Done!" + message);
    }
}
