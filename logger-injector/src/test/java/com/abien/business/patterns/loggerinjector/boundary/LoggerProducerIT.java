package com.abien.business.patterns.loggerinjector.boundary;


import java.util.logging.Logger;
import javax.inject.Inject;
import static org.hamcrest.core.Is.*;
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
 * @author blog.adam-bien.com
 */
@RunWith(Arquillian.class)
public class LoggerProducerIT {

    @Inject
    LogUser logUser;


    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class).
                addClasses(LogUser.class, LogProducer.class, DebugConfiguration.class,  DevNullLogger.class, DelegatingLogger.class).
                addAsManifestResource(
                        new ByteArrayAsset("<beans/>".getBytes()),
                        ArchivePaths.create("beans.xml"));
    }

    @Test
    public void logInjected() {
        assertTrue(logUser.isLogInjected());
    }

    @Test
    public void loggerNameCorrespondsToClassNameNoDebug() {
        Log xRayLogger = logUser.getLogger();
        Logger logger = xRayLogger.getLogger();
        assertTrue(xRayLogger instanceof DelegatingLogger);
        String actual = logger.getName();
        String expected = LogUser.class.getName();
        assertThat(actual, is(expected));

    }
}