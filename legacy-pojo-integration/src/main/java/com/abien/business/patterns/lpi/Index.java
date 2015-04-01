package com.abien.business.patterns.lpi;

import com.abien.business.patterns.lpi.boundary.OrderService;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    OrderService os;
    
    public Object order(){
        os.order();
        return null;
    }
}
