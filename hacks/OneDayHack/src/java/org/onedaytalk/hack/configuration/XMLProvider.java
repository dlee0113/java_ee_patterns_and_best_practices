package org.onedaytalk.hack.configuration;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class XMLProvider implements Provider{

    @Override
    public String getConfiguration() {
        return "from xml";
    }
    
}
