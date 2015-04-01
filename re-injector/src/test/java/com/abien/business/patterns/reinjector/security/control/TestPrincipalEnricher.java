package com.abien.business.patterns.reinjector.security.control;

import java.security.Principal;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Specializes
public class TestPrincipalEnricher extends PrincipalEnricher{
    public static final String PRINCIPAL_NAME = "principal.name";

    @Override
    public Principal getPrincipal() {
        return new Principal() {

            @Override
            public String getName() {
                return System.getProperty(PRINCIPAL_NAME);
            }
        };
    }
}
