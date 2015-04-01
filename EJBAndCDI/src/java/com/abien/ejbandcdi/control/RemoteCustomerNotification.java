package com.abien.ejbandcdi.control;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author blog.adam-bien.com
 */
@Alternative
public class RemoteCustomerNotification implements CustomerNotification{

    //JMS resources injection

    @Override
    public void sendNotification() {
       //sending via JMS
        System.out.println("Remote event distribution!");
    }
}
