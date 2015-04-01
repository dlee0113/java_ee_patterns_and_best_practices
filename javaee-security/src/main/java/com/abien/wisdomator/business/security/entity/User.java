package com.abien.wisdomator.business.security.entity;

import java.util.EnumSet;

/**
 *
 * @author adam-bien.com
 */
public class User {

    private String name;
    private EnumSet<Permission> permissions;

    public User(String name) {
        this.name = name;
        this.permissions = EnumSet.noneOf(Permission.class);
    }
    
    public void add(Permission permission){
        permissions.add(permission);
    }
    
    public boolean isAllowed(Permission permission){
        return permissions.contains(permission);
    }


    public void setPermissions(EnumSet<Permission> permissionForPrincipal) {
        this.permissions = permissionForPrincipal;
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", permissions=" + permissions + '}';
    }
}
