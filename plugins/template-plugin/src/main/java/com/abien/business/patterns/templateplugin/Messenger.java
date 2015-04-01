/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien.business.patterns.templateplugin;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class Messenger {

    private String host;

    public Messenger(String host) {
        this.host = host;
    }
    
    public void sendMessage(String content){
        System.out.println("Sending: " + content +  "to " +host);
    }
}
