/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jax.wshacks.business.goodmorning.control;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author abien
 */
@UnPrecise
//@Precision(Precision.Level.LOW)
public class WakyTimeZone implements TimeZoneProvider{

    @Override
    public String getZone() {
        return "Europe";
    }
    
}
