package com.abien.smokingservers.presentation;

import com.abien.smokingservers.business.smoke.boundary.FireStarter;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Presenter
public class Index {

    @Inject
    FireStarter fireStarter;

    private String testResult;

    public Object fireButNoSmoke() {
        fireStarter.makeSomeFire();
        if(!fireStarter.isSmoke()){
            this.testResult = "Everything works";
        }
        return null;
    }

    public FireStarter getFireStarter() {
        return fireStarter;
    }

    public String getTestResult() {
        return testResult;
    }



    
}
