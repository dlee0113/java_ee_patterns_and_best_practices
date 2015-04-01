package de.javaeesummit;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class RegistrationTest {
    private WebResource resource;
    
    @Before
    public void initClient(){
        Client client = Client.create();
        this.resource = client.resource("http://localhost:8080/unittest/v1/registrations");
    }
    
    @Test
    public void registrations(){
        String result = this.resource.get(String.class);
        assertNotNull(result);
        assertThat(result,is("42 false"));
    }
    
    @Test
    public void tasks(){
        Client client = Client.create();
        
        this.resource = client.resource("http://localhost:8080/Dojorn/resources/tasks");
        ClientResponse task = this.resource.get(ClientResponse.class);
        
        assertNotNull(task);
        System.out.println("Task: " + task.getEntity(Task.class));
        
    
    }
    
}
