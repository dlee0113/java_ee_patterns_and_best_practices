package com.abien.business.patterns.reinjector.security.entity;

import javax.enterprise.inject.Alternative;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Alternative
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Permission {
 
    private String principalName;
    private String credentialName;

    public Permission() {
    }

    public Permission(String principalName, String credentialName) {
        this.principalName = principalName;
        this.credentialName = credentialName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public String getCredentialName() {
        return credentialName;
    }
}
