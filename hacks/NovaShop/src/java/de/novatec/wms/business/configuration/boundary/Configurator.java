/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.novatec.wms.business.configuration.boundary;

import de.novatec.wms.business.configuration.control.MapProvider;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author blog.adam-bien.com
 */
public class Configurator {

    @Inject //@ProviderType(ProviderType.Type.REMOTE)
    Instance<MapProvider> provider;

    @Produces
    public int getProperty(InjectionPoint ip){
        String name = ip.getMember().getName();
        for (MapProvider mapProvider : provider) {
            System.out.println("provider found: " + mapProvider);
        }
        return 6;
        /**
        String value = provider.getConfiguration().get(name);
        if(value == null)
            value = "0";
        return Integer.parseInt(value);
         * */
    }

}
