package com.abien.smokingservers.business.smoke.control;

import javax.ejb.Singleton;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Singleton
public class FireState {

    private boolean fire;
    private boolean smoke;


    public void startFire(){
        this.fire = true;
        this.smoke = false;
    }

    public boolean isFire() {
        return fire;
    }

    public boolean isSmoke() {
        return smoke;
    }




}
