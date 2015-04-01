package com.abien.business.patterns.reinjector.em.boundary;

import com.abien.business.patterns.reinjector.em.entity.ConfigurationEntry;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class ConfigurationService {
    
    @Inject @ReadOnly
    EntityManager read;

    @Inject @Writable
    EntityManager write;

    public List<ConfigurationEntry> getConfiguration() {
        return read.createNamedQuery(ConfigurationEntry.ALL).getResultList();
    }
    
    public ConfigurationEntry getEntry(String key){
        return this.read.find(ConfigurationEntry.class, key);
    }
    
    public ConfigurationEntry saveOrUpdate(ConfigurationEntry ce){
        return write.merge(ce);
    }
    
}
