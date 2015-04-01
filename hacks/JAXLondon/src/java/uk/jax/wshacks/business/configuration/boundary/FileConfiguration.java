/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.configuration.boundary;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abien
 */
public class FileConfiguration implements ConfigurationReader{

    @Override
    public Map<String, String> readConfiguration() {
        return new HashMap<String, String>();
    }
    
}
