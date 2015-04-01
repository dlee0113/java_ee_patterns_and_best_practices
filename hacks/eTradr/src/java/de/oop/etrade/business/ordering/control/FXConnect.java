/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.oop.etrade.business.ordering.control;

/**
 *
 * @author blog.adam-bien.com
 */
//@Exchange(Exchange.Location.MUC)
public class FXConnect implements Connect {

    private int portNumber;

    public FXConnect() {
    }

    
    public FXConnect(int portNumber) {
        this.portNumber = portNumber;
    }

    

    public long getQuote(){
        System.out.println("### With port: " + portNumber);
        return System.currentTimeMillis();
    }

}
