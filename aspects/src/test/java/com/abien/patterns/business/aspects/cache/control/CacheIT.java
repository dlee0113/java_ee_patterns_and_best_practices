package com.abien.patterns.business.aspects.cache.control;

import com.abien.patterns.business.aspects.events.boundary.CacheChangeNotifier;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;

/**
 *
 * @author adam bien, adam-bien.com
 */
@RunWith(Arquillian.class)
public class CacheIT {

    @Inject
    Cache cut;
    
    @Inject
    TestChangeListener  tcl;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "reinjector.jar").
                addClasses(Cache.class,InMemoryCache.class,CacheChangeNotifier.class,TestChangeListener.class).
                addAsManifestResource(
                new ByteArrayAsset(("<beans>"
                + "<decorators>" 
                + "<class>com.abien.patterns.business.aspects.events.boundary.CacheChangeNotifier</class>"
                + "</decorators>"
                +"</beans>").getBytes()),
                ArchivePaths.create("beans.xml"));
    }


    @Test
    public void cacheChangeNotification() {
        String key = "key";
        String value = "value";
        cut.cache(key, value);
        String message = tcl.getMessage();
        assertThat(key, is(message));
    }


}
