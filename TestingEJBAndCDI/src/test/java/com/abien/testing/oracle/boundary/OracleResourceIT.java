package com.abien.testing.oracle.boundary;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import com.abien.testing.configuration.boundary.MessageProvider;
import com.abien.testing.oracle.control.Consultant;
import javax.ejb.EJBException;
import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class OracleResourceIT {
    
    @Inject
    OracleResource cut;
    
    @Inject
    TransactionRollbackValidator validator;

    @Deployment
    public static JavaArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(JavaArchive.class, "oracle.jar").
                addClasses(TransactionRollbackValidator.class,OracleResource.class,MessageProvider.class, Consultant.class).
                addAsManifestResource(
                new ByteArrayAsset("<beans/>".getBytes()),
                ArchivePaths.create("beans.xml"));
    }

    @Test(expected=IllegalStateException.class)
    public void predictFutureWithoutConsultants() throws Exception{
        try {
            cut.predictFutureOfJava();
        } catch (EJBException e) {
            throw e.getCausedByException();
        }
    }
    
    @Test
    public void rollbackWithoutConsultants(){
        assertTrue(validator.isRollback());
    }
}
