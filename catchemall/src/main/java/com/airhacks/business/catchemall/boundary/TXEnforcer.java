package com.airhacks.business.catchemall.boundary;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;

/**
 *
 * @author adam-bien.com
 */
public class TXEnforcer {

    @Resource
    UserTransaction tx;
    private final static Logger LOG = Logger.getLogger(TXEnforcer.class.getName());

    @AroundInvoke
    public Object beginAndCommit(InvocationContext ic) throws Exception {
        try {
            tx.begin();
            Object retVal = ic.proceed();
            tx.commit();
            return retVal;
        } catch (RollbackException e) {
            LOG.severe("-----------------Caught (in interceptor): " + e.getCause());
            throw e;
        } catch (RuntimeException e) {
            LOG.severe("---- Rolling back--Runtime exception occured: " + e);
            tx.rollback();
            throw e;
        }

    }
}
