package com.abien.wisdomator.business.wisdom.boundary;

import com.abien.wisdomator.business.wisdom.control.CustomSecuredWisdomStorage;
import com.abien.wisdomator.business.wisdom.control.WisdomStorage;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("wisdom")
@Produces(MediaType.TEXT_PLAIN)
public class WisdomResource {

    @Inject
    CustomSecuredWisdomStorage storage;

    @GET
    public String wisdom() {
        return storage.wisdom();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String wisdom(
            @FormParam("wisdom") String wisdom) {
        storage.wisdom(wisdom);
        return "thanks!";
    }
}
