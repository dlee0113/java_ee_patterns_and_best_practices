/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vegas.casino.business;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author blog.adam-bien.com
 */
@Alternative
public class GermanBandit implements IBandit{

    @Override
    public void stealSomething() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
