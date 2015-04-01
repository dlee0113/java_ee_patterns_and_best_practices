package com.ims.business.management.boundary;

import com.ims.business.management.control.AnotherIMS;
import com.ims.business.management.control.PowerSource;
import com.ims.business.management.entity.IronMan;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sun.print.PSPrinterJob;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("ironmans")
@Stateless
@Interceptors(GovernmentAuditService.class)
public class IronManService {

    @Inject
    Event<String> distribution;

    @PersistenceContext
    EntityManager em;

    @Inject
    PowerSource ps;

    @EJB
    AnotherIMS ims;

    @Context
    HttpServletRequest request;

    @PostConstruct
    public void initialize(){
        ps = new PowerSource(42);
    }



    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response createIronman(IronMan ironMan){
        em.merge(ironMan);
        distribution.fire("Fire !");
        System.out.println("Hello ironman " + ps.getPower());
        return Response.ok().build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public IronMan getIronMan(){
        return new IronMan(10);

    }
}
