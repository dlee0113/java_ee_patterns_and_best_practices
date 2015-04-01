/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.duke.mugs.business.order.control;

/**
 *
 * @author blog.adam-bien.com
 */
public class Mailer {

    private String message;

    public Mailer(String message) {
        this.message = message;
    }




    public void sendMail(){
        System.out.println("Mail sent! " + message);
    }
}
