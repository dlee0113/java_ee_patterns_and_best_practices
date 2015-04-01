package com.abien.wisdomator.business.security.control;

import com.abien.wisdomator.business.security.entity.Permission;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 *
 * @author adam-bien.com
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class InMemoryPermissionsRealm {
    
    private Map<String,EnumSet<Permission>> customStore;
    
    @PostConstruct
    public void populateRealm(){
        this.customStore = new HashMap<String, EnumSet<Permission>>();
        this.customStore.put("james", EnumSet.allOf(Permission.class));
        this.customStore.put("blogger", EnumSet.noneOf(Permission.class));
    }
    
    public EnumSet<Permission> getPermissionForPrincipal(String userName){
        EnumSet<Permission> configuredPermissions = this.customStore.get(userName);
        if(configuredPermissions != null) {
            return configuredPermissions;
        }
        else {
            return EnumSet.noneOf(Permission.class);
        }
    }
}
