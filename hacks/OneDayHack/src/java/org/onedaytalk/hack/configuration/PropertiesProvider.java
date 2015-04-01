package org.onedaytalk.hack.configuration;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class PropertiesProvider implements Provider{

    @Override
    public String getConfiguration() {
        return "from properties";
    }
    
}
