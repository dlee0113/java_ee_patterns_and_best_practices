package com.abien.business.patterns.configurator.primitives.provider;

import com.abien.business.patterns.configurator.staging.Stage;
import com.abien.business.patterns.configurator.staging.StageDependent;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * User: blog.adam-bien.com
 * Date: 14.02.11
 * Time: 19:06
 */
@Path("configuration")
@Produces(TEXT_PLAIN)
@LocalBean
@Singleton
public class Configurator implements ConfiguratorMXBean {

    private Set<String> unconfiguredFields;

    @Inject
    private Instance<ConfigurationProvider> configurationProvider;
    
    private Map<String, String> configuration;
    private ObjectName objectName;
    private MBeanServer platformMBeanServer;
    
    @Resource
    SessionContext sc;

    @PostConstruct
    public void fetchConfiguration() {
        this.configuration = new HashMap<String, String>() {{
            put("message", "-configurable-");
            put("greetings", "-highly configurable-");
            put("Development.stagedMessage", "Development: -highly configurable-");
            put("repetition", "2");
            put("debug", "false");
        }};
        this.unconfiguredFields = new HashSet<String>();
        mergeWithCustomConfiguration();
        registerInJMX();
    }
    
    void registerInJMX(){
     try {
            objectName = new ObjectName("Configurator:type=" + this.getClass().getName());
            platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
            Configurator thiz = sc.getBusinessObject(Configurator.class);
            platformMBeanServer.registerMBean(thiz, objectName);
        } catch (Exception e) {
            throw new IllegalStateException("Problem during registration of Monitoring into JMX:" + e);
        }
     }
    
    @PreDestroy
    public void unregisterFromJMX() {
        try {
            platformMBeanServer.unregisterMBean(this.objectName);
        } catch (Exception e) {
            throw new IllegalStateException("Problem during unregistration of Monitoring into JMX:" + e);
        }
    }
    

    public boolean doesCustomConfigurationExist() {
        return !configurationProvider.isUnsatisfied();
    }

    void mergeWithCustomConfiguration() {
        for (ConfigurationProvider provider : configurationProvider) {
            Map<String, String> customConfiguration = provider.getConfiguration();
            this.configuration.putAll(customConfiguration);
            System.out.println("Provider: " + provider + " " + this.configuration);
        }
    }


    @javax.enterprise.inject.Produces
    public String getString(InjectionPoint point) {
        String fieldName = obtainConfigurableName(point);
        return getValueForKey(fieldName);
    }

    @javax.enterprise.inject.Produces @StageDependent
    public String getString(InjectionPoint point,Stage stage) {
        String fieldName = obtainConfigurableName(point);
        fieldName = stage.name() + "." + fieldName;
        return getValueForKey(fieldName);
    }

    private String getValueForKey(String fieldName) {
        String valueForFieldName = configuration.get(fieldName);
        if (valueForFieldName == null) {
            this.unconfiguredFields.add(fieldName);
        }
        return valueForFieldName;
    }
    
    String obtainConfigurableName(InjectionPoint ip){
        AnnotatedField field = (AnnotatedField) ip.getAnnotated();
        Configurable configurable = field.getAnnotation(Configurable.class);
        if(configurable != null){
            return configurable.value();
        }else{
            return ip.getMember().getName();
        }
    }

    @javax.enterprise.inject.Produces
    public long getLong(InjectionPoint point) {
        String stringValue = getString(point);
        if (stringValue == null) {
            return 0;
        }
        return Long.parseLong(stringValue);
    }

    @javax.enterprise.inject.Produces
    public int getInteger(InjectionPoint point) {
        String stringValue = getString(point);
        if (stringValue == null) {
            return 0;
        }
        return Integer.parseInt(stringValue);
    }

    @javax.enterprise.inject.Produces
    public boolean getBoolean(InjectionPoint point) {
        String stringValue = getString(point);
        if (stringValue == null) {
            return false;
        }
        return Boolean.parseBoolean(stringValue);
    }


    public Set<String> getUnconfiguredFields() {
        return this.unconfiguredFields;
    }


    @GET
    @Path("{key}")
    public String getEntry(@PathParam("key") String key) {
        return configuration.get(key);
    }

    @GET
    @Override
    public String getConfiguration() {
        return this.configuration.toString();
    }

    @PUT
    @Path("{key}")
    @Consumes(TEXT_PLAIN)
    public Response addEntry(@PathParam("key") String key, String value, @Context UriInfo uriInfo) {
        Response response = null;
        if (this.configuration.containsKey(key)) {
            response = Response.noContent().build();
        } else {
            URI uri = uriInfo.getAbsolutePathBuilder().build(key);
            response = Response.created(uri).build();
        }
        this.configuration.put(key, value);
        return response;
    }

    public void addEntry(String key,String value){
        this.configuration.put(key, value);
    }
    
    @DELETE
    @Path("{key}")
    public Response deleteEntry(@PathParam("key") String key) {
        this.configuration.remove(key);
        return Response.noContent().build();
    }

    public void debugEnabled() {
        this.configuration.put("debug", Boolean.TRUE.toString());
    }

    public void debugDisabled() {
        this.configuration.put("debug", Boolean.FALSE.toString());
    }
}


