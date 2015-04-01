package com.abien.patterns.business.tomeealien;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author adam-bien.com
 */
@Stateless
public class HelloBoundary {
    
    public String hello(){
        return "Good Morning: " + new Date();
    }
}
