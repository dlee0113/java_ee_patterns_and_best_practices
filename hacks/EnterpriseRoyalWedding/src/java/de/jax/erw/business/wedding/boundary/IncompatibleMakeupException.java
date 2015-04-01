package de.jax.erw.business.wedding.boundary;

import javax.ejb.ApplicationException;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@ApplicationException(rollback=false)
public class IncompatibleMakeupException extends Exception{
    
}
