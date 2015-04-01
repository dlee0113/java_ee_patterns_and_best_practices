package com.abien.business.patterns.reinjector.security.control;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author adam bien, adam-bien.com
 */
public class PermissionProviderTest {
    
    PermissionProvider cut;
    
    @Before
    public void init(){
        this.cut = new PermissionProvider();
    }

    @Test
    public void anonymous() {
        String expected = PermissionProvider.NOTHING;
        String actual = this.cut.getPermission("anonymous");
        assertThat(actual,is(expected));
    }

    @Test
    public void duke() {
        String expected = PermissionProvider.EVERYTHING;
        String actual = this.cut.getPermission("duke");
        assertThat(actual,is(expected));
    }
}
