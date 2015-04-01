package com.abien.business.patterns.reinjector.security.control;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class PermissionProvider {
    public final static String NOTHING = "-nothing-";
    public final static String EVERYTHING = "-everything-";

    public String getPermission(String principal){
        if("anonymous".equalsIgnoreCase(principal)){
            return NOTHING;
        }
        return EVERYTHING;
    }
}
