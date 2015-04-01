package com.abien.business.patterns.configurator.staging;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
public class ConnectorManager {
    @Produces @StageDependent
    public EISConnector connect(Stage projectStage){
       switch(projectStage){
           case Production: 
               return new LegacyConnector();
           default:
               return new EISMock();
       }
    }
}
