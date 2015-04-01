/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.logging.boundary;

import java.util.logging.Logger;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Log {
    
    private Logger logger;

    public Log(Class clazz) {
        this.logger = Logger.getLogger(clazz.getName());
    }
    
    public void info(String message){
        this.logger.info(message);
    }
    
}
