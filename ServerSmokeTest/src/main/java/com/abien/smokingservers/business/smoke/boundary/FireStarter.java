package com.abien.smokingservers.business.smoke.boundary;

import com.abien.smokingservers.business.smoke.control.FireState;
import com.abien.smokingservers.business.smoke.control.LegacyFireFighter;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Interceptors(SmokeDetector.class)
@Stateless
public class FireStarter {

    @Inject
    FireState fireState;

    @Inject
    Event<Boolean> event;

    @Inject
    LegacyFireFighter fighter;

    public void makeSomeFire(){
        fireState.startFire();
        event.fire(fireState.isSmoke());
        fighter.fighFireWithFire();
    }

    public boolean isSmoke(){
        return fireState.isSmoke();
    }

}
