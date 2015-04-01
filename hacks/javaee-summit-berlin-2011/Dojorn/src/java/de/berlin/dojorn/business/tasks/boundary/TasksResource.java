package de.berlin.dojorn.business.tasks.boundary;

import de.berlin.dojorn.business.tasks.entity.Task;
import java.awt.PageAttributes;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("tasks")
@Stateless
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_XML)
public class TasksResource {
    
    @Inject
    TaskService ts;
    
    @GET
    public Response aMethodName(){
        Task task = new Task("duke", "rocks");
        return Response.ok(task).build();
    }
    
    @GET
    @Path("{id}-{something}")
    public Task get(@PathParam("id") int id,@PathParam("something") String something){
        return new Task("" + id,something);
    }
    
    
    @Path("subtask")
    public SubTaskResource get(){
        return new SubTaskResource("duke-hugo");
    }
    
    @POST
    public Response create(Task task){
        Task save = ts.save(task);
        long id = save.getId();
        URI create = URI.create("/"+id);
        return Response.created(create).build();
    }
    
}
