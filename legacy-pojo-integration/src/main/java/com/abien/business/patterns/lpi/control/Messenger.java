package com.abien.business.patterns.lpi.control;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class Messenger {

    private String host;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
    public void connect(){
        System.out.println("Connecting " + host + ":" + port);
    }
    
    public void send(String msg){
        System.out.println("Sending " + msg + " to " + host + ":" + port);
    }
}
