package com.abien.business.patterns.customscope;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.InvocationException;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ClientFactory;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class CustomScopeIT {

    private static final String URI = "http://localhost:8080/custom-scope/resources/customscope/";
    private Client client;
    private Target target;

    @Before
    public void initializeClient() {
        this.client = ClientFactory.newClient();
        this.target = this.client.target(URI);
    }

    @Test
    public void creationAndDisposal() {
        String expected = "000";
        String actual = getStringWithGET("injection");
        assertThat(actual,is("++"));
        actual = getStringWithGET("instanceCount");
        assertThat(actual,is("111"));
        actual = getStringWithGET("shutdown");
        assertThat(actual,is("+"));
        actual = getStringWithGET("instanceCount");
        assertThat(actual,is(expected));
    }
    
    @Test
    public void sameTypeInjectedTwice(){
        String actual = getStringWithGET("sameinstance");
        assertThat(actual,is("+"));
    }

    @Test
    public void sameTypeInjectedTwiceFetchedLazily(){
        String actual = getStringWithGET("samelazyinstance");
        assertThat(actual,is("+"));
    }

    private String getStringWithGET(String path) throws NullPointerException, InvocationException {
        return this.target.path(path).request(MediaType.TEXT_PLAIN).get(String.class);
    }

}
