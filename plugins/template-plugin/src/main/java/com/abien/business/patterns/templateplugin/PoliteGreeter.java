package com.abien.business.patterns.templateplugin;

import javax.enterprise.inject.Specializes;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Specializes
public class PoliteGreeter extends Greeter{

    @Override
    public String getGreetings() {
        return "Dear " + super.getGreetings();
    }

}
