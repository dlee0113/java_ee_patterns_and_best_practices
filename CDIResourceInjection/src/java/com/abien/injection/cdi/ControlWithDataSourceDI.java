package com.abien.injection.cdi;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class ControlWithDataSourceDI {

    @Resource(name="jdbc/sample")
    DataSource ds;

    public String getConnectionAsString(){
        try {
            return ds.getConnection().toString();
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot get connection: " + ex);
        }
    }
}
