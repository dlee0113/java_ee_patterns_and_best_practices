package com.abien.business.patterns.reinjector.security.control;

import com.abien.business.patterns.reinjector.security.entity.Permission;
import java.security.Principal;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class PrincipalEnricher {

    @Inject
    Principal principal;
    
    @Inject
    PermissionProvider permissionProvider;

    Principal getPrincipal() {
        return principal;
    }
    
    @Produces
    public Permission grant(){
        String name = getPrincipal().getName();
        String permission = permissionProvider.getPermission(name);
        return new Permission(name, permission);
    }
}
