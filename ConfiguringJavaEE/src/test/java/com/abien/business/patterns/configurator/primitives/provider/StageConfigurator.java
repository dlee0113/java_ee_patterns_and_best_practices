package com.abien.business.patterns.configurator.primitives.provider;

import com.abien.business.patterns.configurator.staging.Stage;
import javax.enterprise.inject.Produces;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class StageConfigurator {

    @Produces
    public Stage configurator(){
        return Stage.Development;
    }
}
