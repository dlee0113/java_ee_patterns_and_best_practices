/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.novatec.wms.business.spamming.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author blog.adam-bien.com
 */

@Startup
@Singleton(name="hugo")
public class ImportantSingleton {

    @PostConstruct
    public void onStart(){
        System.out.println("Important initialized");
    }
}
