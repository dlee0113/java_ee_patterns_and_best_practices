package com.airhacks.business.catchemall.boundary;

import com.airhacks.business.catchemall.entity.SomeEntity;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adam-bien.com
 */
@Stateless
@Interceptors(TXEnforcer.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DataStore {

    @PersistenceContext
    EntityManager em;

    private final static Logger LOG = Logger.getLogger(DataStore.class.getName());

    public SomeEntity saveOrUpdate(SomeEntity someEntity) {
        return em.merge(someEntity);
    }

    public void update(String id) {
        SomeEntity forUpdate = this.em.find(SomeEntity.class, id);
        forUpdate.makeDirty();
    }

}
