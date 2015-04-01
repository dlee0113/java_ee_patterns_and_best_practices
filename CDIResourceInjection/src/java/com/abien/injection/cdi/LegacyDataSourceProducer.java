package com.abien.injection.cdi;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

/**
 *
 * @author blog.adam-bien.com
 */
public class LegacyDataSourceProducer {

    @Produces @Legacy @Resource(name="jdbc/sample")
    DataSource ds;
}
