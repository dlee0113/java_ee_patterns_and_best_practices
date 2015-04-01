package com.abien.business.patterns.reinjector.em.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name=ConfigurationEntry.ALL,query="Select c from ConfigurationEntry c")
})
public class ConfigurationEntry {
    public static final String ALL = "findAll";
    @Id
    @Column(name="c_key")
    private String key;
    @Column(name="c_value")
    private String value;

    public ConfigurationEntry() {
    }

    public ConfigurationEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    
    
}
