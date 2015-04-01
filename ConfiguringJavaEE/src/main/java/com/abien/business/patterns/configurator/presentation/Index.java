package com.abien.business.patterns.configurator.presentation;

import com.abien.business.patterns.configurator.primitives.consumer.Greeter;
import com.abien.business.patterns.configurator.staging.EISConnector;
import com.abien.business.patterns.configurator.staging.StageDependent;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
@Model
public class Index {
    
    @Inject @StageDependent
    EISConnector connector;
    
    @Inject
    Greeter messenger;
    
    public String getInfo() {
        return connector.fetchInfo();
    }
    
    public String getHello(){
        return messenger.hello();
    }
    
    public String getStagedMessage(){
        return messenger.stagedMessage();
    }
}
