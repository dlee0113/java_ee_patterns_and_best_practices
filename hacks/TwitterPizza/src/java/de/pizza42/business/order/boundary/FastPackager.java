/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pizza42.business.order.boundary;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author blog.adam-bien.com
 */
public class FastPackager implements PackagingService{

    @Override
    public void hello() {
        System.out.println("Fast");
    }

}
