/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien.business.patterns.configurator.primitives.provider;

import com.abien.business.patterns.configurator.primitives.provider.Configurator;
import com.abien.business.patterns.configurator.primitives.provider.ConfigurationProvider;
import com.abien.business.patterns.configurator.primitives.provider.Configurable;
import com.abien.business.patterns.configurator.RESTConfig;
import com.abien.business.patterns.configurator.staging.Stage;
import com.abien.business.patterns.configurator.staging.StageDependent;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;

/**
 *
 * @author adam bien, adam-bien.com
 */
@RunWith(Arquillian.class)
public class ConfiguratorIT {


    @Inject
    Configurator configurator;
    
    @Inject @Configurable("greetings")
    private String message;

    @Inject @Configurable("greetings")
    private Instance<String> dynamicMessage;

    @Inject @StageDependent
    private String stagedMessage;
    

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "configurator.war").
                addClasses(Configurator.class,RESTConfig.class,Stage.class,Configurable.class,ConfigurationProvider.class,StageConfigurator.class).
                addAsWebInfResource(
                        new ByteArrayAsset("<beans/>".getBytes()),
                        ArchivePaths.create("beans.xml"));
    }

   @Test
   public void injection(){
       assertNotNull(configurator);
   }

   @Test
   public void configurable(){
       assertThat(message,is("-highly configurable-"));
   }

   @Test
   public void stageDependent(){
       assertThat(stagedMessage,is("Development: -highly configurable-"));
   }
   
   @Test
   public void dynamicallyConfigurable(){
      String message = dynamicMessage.get();
      assertNotNull(message);
      assertThat(message,is("-highly configurable-"));
      String expected = "reconfigured";
      configurator.addEntry("greetings", expected);
      message = dynamicMessage.get();
      assertThat(message,is(expected));

   }
}
