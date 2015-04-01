/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.pizza42.business.order.boundary;

/**
 *
 * @author blog.adam-bien.com
 */
public class SlowPackager implements PackagingService{

    @Override
    public void hello() {
        System.out.println("Slow");
    }

}
