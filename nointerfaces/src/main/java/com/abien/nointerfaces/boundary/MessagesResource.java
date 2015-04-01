package com.abien.nointerfaces.boundary;

import com.abien.nointerfaces.control.Communicator;
import com.abien.nointerfaces.entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("messages")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResource {
    
    @Inject @Any
    Instance<Communicator> communicatorInstances;
    
    @GET
    public List<Message> allMessages(){
        System.out.println("--isAmbiguous: " + communicatorInstances.isAmbiguous());
        System.out.println("--isUnsatisfied: " + communicatorInstances.isUnsatisfied());
        List<Message> allMessages = new ArrayList<Message>();
        for (Communicator communicator : communicatorInstances) {
            allMessages.addAll(communicator.getRecentMessages());
        }
        return allMessages;
        }
    }
