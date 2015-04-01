package com.javaone.coolparts.two;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class XMLConfigurationProvider implements ConfigurationProvider{

    @Override
    public Map<String, String> getConfiguration() {
        return new HashMap<String, String>();
    }
    
}
