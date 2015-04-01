/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.configuration.boundary;

import java.util.Map;

/**
 *
 * @author abien
 */
public interface ConfigurationReader {
    
    public Map<String,String> readConfiguration();
}
