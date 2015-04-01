/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.business.management.presentation;

import com.ims.business.management.boundary.IronManService;
import com.ims.business.management.entity.IronMan;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Presenter
public class Index {

    @EJB
    IronManService ims;

    private IronMan ironMan = new IronMan();

    public void hiIron() {
        System.out.println("Hello from presentation");
        ims.createIronman(ironMan);
    }

    public IronMan getIronMan() {
        return ironMan;
    }


}
