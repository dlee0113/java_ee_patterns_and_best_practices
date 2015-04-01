package com.abien.patterns.business.tomeealien;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author adam-bien.com
 */
@RunWith(Arquillian.class)
public class HelloBoundaryIT {
    
    @Inject
    HelloBoundary cut;
    
    @Deployment
    public static WebArchive deploy(){
        return ShrinkWrap.create(WebArchive.class).
                addClasses(HelloBoundary.class).
                addAsWebInfResource(EmptyAsset.INSTANCE,
                ArchivePaths.create("beans.xml"));
    }
   
    @Test
    public void injection() {
        assertNotNull(cut);
        assertNotNull(cut.hello());
        assertTrue(cut.hello().startsWith("Good"));
    }
}
