/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.novatec.wms.business.configuration.control;

import de.novatec.wms.business.configuration.boundary.ProviderType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blog.adam-bien.com
 */
//@ProviderType(ProviderType.Type.REMOTE)
public class DBProvider implements MapProvider{

    @Override
    public Map<String, String> getConfiguration() {
        return new HashMap<String, String>();
    }

}
