/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mixt.rentacar.business.configuration.boundary;

import java.util.Map;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public interface ConfigurationSource {
    
    Map<String, String> getConfiguration();
}
