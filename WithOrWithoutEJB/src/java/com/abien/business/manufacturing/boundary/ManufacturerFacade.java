/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abien.business.manufacturing.boundary;

import com.abien.business.manufacturing.entity.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author http://blog.adam-bien.com
 */
@Stateless
public class ManufacturerFacade {
    @PersistenceContext(unitName = "WithOrWithoutEJBPU")
    private EntityManager em;

    public void create(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public void edit(Manufacturer manufacturer) {
        em.merge(manufacturer);
    }

    public void remove(Manufacturer manufacturer) {
        em.remove(em.merge(manufacturer));
    }

    public Manufacturer find(Object id) {
        return em.find(Manufacturer.class, id);
    }

    public List<Manufacturer> findAll() {
        CriteriaQuery cq = em.getQueryBuilder().createQuery();
        cq.select(cq.from(Manufacturer.class));
        return em.createQuery(cq).getResultList();
    }

    public List<Manufacturer> findRange(int[] range) {
        CriteriaQuery cq = em.getQueryBuilder().createQuery();
        cq.select(cq.from(Manufacturer.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Manufacturer as o").getSingleResult()).intValue();
    }

}
