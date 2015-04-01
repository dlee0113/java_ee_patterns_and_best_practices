package com.abien.testing.oracle.boundary;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
public class TransactionRollbackValidator {
    
    @Resource
    SessionContext sc;
    
    @EJB 
    OracleResource os;
    
    public boolean isRollback(){
        try {
            os.predictFutureOfJava();
        } catch (Exception e) {
            //swallow all exceptions intentionally
        }
                
        return sc.getRollbackOnly();
    }
}
