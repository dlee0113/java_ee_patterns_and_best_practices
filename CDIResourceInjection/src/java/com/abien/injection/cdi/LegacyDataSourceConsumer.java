package com.abien.injection.cdi;

import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author blog.adam-bien.com
 */
@Path("legacyds")
@Stateless
public class LegacyDataSourceConsumer {

    @Inject @Legacy
    DataSource ds;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDataSource(){
        try {
            return ds.getConnection().toString();
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot obtain connection: " + ex);
        }
    }
}
