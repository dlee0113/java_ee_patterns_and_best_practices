package com.abien.patterns.aop;

import java.util.logging.Logger;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class Audit {

    private static final Logger logger = Logger.getLogger(Audit.class.getName());
    
    public void write(String msg){
        logger.info(msg);
    }
}
