package de.jax.erw.business.wedding.control;

import de.jax.erw.business.wedding.entity.WedLock;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public interface Filter {
    
    public boolean censor(WedLock lock);
}
