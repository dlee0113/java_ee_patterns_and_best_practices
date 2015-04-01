package de.jax.erw.business.wedding.control;

import de.jax.erw.business.wedding.entity.WedLock;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
//@Agency(Agency.Factor.STRANGE)
public class CIA implements Filter{

    @Override
    public boolean censor(WedLock lock) {
        return false;
    }
    
}
