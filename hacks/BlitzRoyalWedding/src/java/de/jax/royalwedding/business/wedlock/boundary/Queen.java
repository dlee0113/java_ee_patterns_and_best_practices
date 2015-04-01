package de.jax.royalwedding.business.wedlock.boundary;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
//@Stateless
public class Queen {
    
    private Map<String,String> configuration = new HashMap<String, String>();
    
    @Inject
    Instance<PropertiesProvider> provider;
    
    @PostConstruct
    public void initialize(){
        configuration.put("decision", "OK!");
        configuration.put("message", "Heirate Mich!");
        for (PropertiesProvider propertiesProvider : provider) {
            configuration.putAll(propertiesProvider.getConfiguration());
        }
    }
 
    @Produces
    public String getString(InjectionPoint ip){
        String name = ip.getMember().getName();
        return configuration.get(name);
    }
    
    
}
