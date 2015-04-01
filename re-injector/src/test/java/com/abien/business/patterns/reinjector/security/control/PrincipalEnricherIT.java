package com.abien.business.patterns.reinjector.security.control;

import com.abien.business.patterns.reinjector.security.entity.Permission;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author adam bien, adam-bien.com
 */
@RunWith(Arquillian.class)
public class PrincipalEnricherIT {

    @Inject
    Instance<Permission> permissions;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "reinjector.jar").
                addClasses(PermissionProvider.class, Permission.class,TestPrincipalEnricher.class,PrincipalEnricher.class).
                addAsManifestResource(
                new ByteArrayAsset("<beans/>".getBytes()),
                ArchivePaths.create("beans.xml"));
    }
    
    @Test
    public void anonymousAuthentication(){
        System.setProperty(TestPrincipalEnricher.PRINCIPAL_NAME, "anonymous");
        Permission permission = permissions.get();
        assertThat(permission.getCredentialName(),is(PermissionProvider.NOTHING));
    }

    @Test
    public void successfulAuthentication(){
        System.setProperty(TestPrincipalEnricher.PRINCIPAL_NAME, "duke");
        Permission permission = permissions.get();
        assertThat(permission.getCredentialName(),is(PermissionProvider.EVERYTHING));
    }
}
