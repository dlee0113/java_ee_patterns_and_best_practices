/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ims.business.management.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class PowerSourceFactory {

    @Produces
    public PowerSource create(){
        return new PowerSource(42);
    }
}
