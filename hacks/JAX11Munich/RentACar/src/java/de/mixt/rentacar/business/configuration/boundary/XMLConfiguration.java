/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.configuration.boundary;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class XMLConfiguration implements ConfigurationSource{

    @Override
    public Map<String, String> getConfiguration() {
        Map<String,String> configuration = new HashMap<String, String>();
        configuration.put("key", "value");
        return configuration;
    }
    
}
