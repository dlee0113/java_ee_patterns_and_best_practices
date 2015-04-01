/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author abien
 */
@Stateless
public class IPSniffer {
    
    
    @Inject
    private Instance<Integer> port;

    public void sniff() {
        System.out.println("---- port: " + port.get());
    }
}
