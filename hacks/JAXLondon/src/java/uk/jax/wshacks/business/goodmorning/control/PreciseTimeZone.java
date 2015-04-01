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
@Precise
//@Precision(Precision.Level.HIGH)
public class PreciseTimeZone implements TimeZoneProvider{

    @Override
    public String getZone() {
        return "UK";
    }
    
}
