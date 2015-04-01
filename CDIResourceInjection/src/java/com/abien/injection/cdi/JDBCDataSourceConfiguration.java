package com.abien.injection.cdi;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@DataSourceDefinition(
    className="org.apache.derby.jdbc.ClientDataSource",
    serverName="localhost",
    name="java:global/jdbc/InjectionSample",
    databaseName="InjectionSample;create=true",
    portNumber=1527,
    user="sample",
    password="sample"
)
@Path("datasourcedefinition")
@Stateless
public class JDBCDataSourceConfiguration {

    @Resource(lookup="java:global/jdbc/InjectionSample")
    private DataSource dataSource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDataSourceToString(){
        try {
            return dataSource.getConnection().toString();
        } catch (SQLException ex) {
            throw new IllegalStateException("Problems fetch Connection: " + ex);
        }
    }

}
