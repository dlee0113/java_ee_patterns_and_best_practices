package com.abien.business.patterns.plugin.testapp.boundary;

import com.abien.business.patterns.plugin.hessian.HessianSerializer;
import com.abien.business.patterns.plugin.java.JavaSerializer;
import com.abien.business.patterns.plugin.serializer.Serialization;
import com.abien.business.patterns.plugin.serializer.SerializationType;
import com.abien.business.patterns.plugin.serializer.Serializer;
import com.sun.tools.ws.wscompile.Plugin;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@RunWith(Arquillian.class)
public class PluginsIT {
    

    @Inject @Any
    Instance<Serializer> plugins;
    
    @Inject @Serialization(Serialization.Type.OPTIMIZED)
    Serializer optimized;

    @Inject @Serialization(Serialization.Type.DEFAULT)
    Serializer standard;
    
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "plugins.jar").
                addClasses(Plugin.class,JavaSerializer.class,HessianSerializer.class,NullSerializer.class).
                addAsManifestResource(
                new ByteArrayAsset("<beans/>".getBytes()),
                ArchivePaths.create("beans.xml"));
    }

    @Test
    public void discoverPlugins() {
        assertTrue(plugins.isAmbiguous());
        assertFalse(plugins.isUnsatisfied());
        List<Class> serializers = new ArrayList<>();
        for (Serializer serializer : plugins) {
            serializers.add(serializer.getClass());
        }
        assertTrue(serializers.contains(JavaSerializer.class));
        assertTrue(serializers.contains(HessianSerializer.class));
        assertTrue(serializers.contains(NullSerializer.class));
        assertThat(serializers.size(),is(3));
    }
    
    @Test
    public void defaultInjection(){
        assertNotNull(this.standard);
    }

    @Test
    public void optimizedInjection(){
        assertNotNull(this.optimized);
    }
    
    @Test
    public void dynamicSelection(){
        Serializer actual = this.plugins.select(new SerializationType(Serialization.Type.DEFAULT)).get();
        assertThat(actual,instanceOf(this.standard.getClass()));
    }
    
    
}
