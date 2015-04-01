package de.jax.erw.business.configuration.boundary;

import java.lang.management.ManagementFactory;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Startup
@Path("configuration")
@Singleton
public class Configurator implements ConfiguratorMXBean {
    private ObjectName objectName;
 
    private Map<String,String> configuration = new HashMap<String, String>();
    private MBeanServer server;
    
    
    @PostConstruct
    public void initialize(){
        configuration.put("email", "chief@kingdom.com");
        configuration.put("greeting", "hey joe");
        this.register();
    }
    
    public void register(){
        this.server = ManagementFactory.getPlatformMBeanServer();
        try {
            objectName = new ObjectName("wedding:type=" + this.getClass().getName());
            server.registerMBean(this, objectName);
        } catch (Exception ex) {
            throw new IllegalStateException("Cannot register: " + ex);
        }
    }
    
    @GET
    @javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
    @Override
    public String getConfiguration(){
        return configuration.toString();
    }
    
    @GET
    @Path("{key}")
    @javax.ws.rs.Produces(MediaType.TEXT_PLAIN)
    public String getEntry(@PathParam("key") String key){
        return configuration.get(key);
    }
    
    @PUT
    @Path("{key}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response setEntry(@PathParam("key") String key,String entry){
        Response response = null;
        if(configuration.containsKey(key)){
            response = Response.ok().header("hey", "joe").build();
        }else{
            URI uri = URI.create(key);
            response = Response.created(uri).build();
        }
        configuration.put(key, entry);
        return response;
    }
            
   // @Produces
    public String getString(InjectionPoint ip){
        String name = ip.getMember().getName();
        System.out.println(" " + name);
        return configuration.get(name);
    }
    
    @PreDestroy
    public void deregister(){
        try {
            this.server.unregisterMBean(objectName);
        } catch (Exception ex) {
            Logger.getLogger(Configurator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
