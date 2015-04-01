package com.abien.ejbandcdi;
import javax.ejb.Stateless;
/**
 *
 * @author blog.adam-bien.com
 */
@Stateless
public class LightweightPojo {

    public String hello(){
        return "I'm very lightweight !";
    }

}
