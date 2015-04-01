package com.abien.testing.oracle.boundary;

import com.abien.testing.oracle.control.PredictionAudit;
import com.abien.testing.oracle.entity.Prediction;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Path("predictions")
@Stateless
public class PredictionArchiveResource {

    @EJB
    PredictionAudit audit;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prediction> allPredictions(@DefaultValue("5") @QueryParam("max") int max) {
        List<Prediction> allPredictions = audit.allPredictions();
        if (allPredictions.size() <= max) {
            return allPredictions;
        } else {
            return allPredictions.subList(0, max);
        }
    }
}
