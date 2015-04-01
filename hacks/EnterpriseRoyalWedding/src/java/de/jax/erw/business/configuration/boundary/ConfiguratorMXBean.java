/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jax.erw.business.configuration.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public interface ConfiguratorMXBean {

    String getConfiguration();
    
}
