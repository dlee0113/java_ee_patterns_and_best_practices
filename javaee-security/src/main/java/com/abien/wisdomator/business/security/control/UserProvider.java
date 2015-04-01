package com.abien.wisdomator.business.security.control;

import com.abien.wisdomator.business.security.entity.User;
import java.security.Principal;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
public class UserProvider {

    @Inject
    Principal principal;
    
    @Inject
    InMemoryPermissionsRealm realm;

    @Produces
    public User fetch(){
        User user = new User(principal.getName());
        user.setPermissions(realm.getPermissionForPrincipal(principal.getName()));
        return user;
    }
}
