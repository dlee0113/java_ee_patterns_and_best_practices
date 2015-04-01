/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.duke.mugs.business.order.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author blog.adam-bien.com
 */
public class MailerFactory {

    @Produces
    public Mailer create(){
        return new Mailer("From factory");
    }
}
