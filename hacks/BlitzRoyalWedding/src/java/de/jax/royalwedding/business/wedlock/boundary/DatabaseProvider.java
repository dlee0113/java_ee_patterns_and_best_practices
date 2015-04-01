package de.jax.royalwedding.business.wedlock.boundary;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class DatabaseProvider implements PropertiesProvider{

    @Override
    public Map<String, String> getConfiguration() {
        Map<String,String> configuration = new HashMap<String, String>();
        configuration.put("decision","no go");
        return configuration;
    }
    
}
