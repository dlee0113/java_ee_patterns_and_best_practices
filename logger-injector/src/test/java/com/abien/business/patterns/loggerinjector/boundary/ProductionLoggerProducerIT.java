package com.abien.business.patterns.loggerinjector.boundary;


import javax.inject.Inject;
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
public class ProductionLoggerProducerIT {

    @Inject
    LogUser logUser;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class).
                addClasses(LogUser.class, LogProducer.class, Configuration.class, DevNullLogger.class, DelegatingLogger.class).
                addAsManifestResource(
                        new ByteArrayAsset("<beans/>".getBytes()),
                        ArchivePaths.create("beans.xml"));
    }

    @Test
    public void productionLoggerInjected() {
        Log xRayLogger = logUser.getLogger();
        assertTrue(xRayLogger instanceof DevNullLogger);
    }
}