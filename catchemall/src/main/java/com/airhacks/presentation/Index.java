package com.airhacks.presentation;

import com.airhacks.business.catchemall.boundary.DataStore;
import com.airhacks.business.catchemall.entity.SomeEntity;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@Model
public class Index {

    @Inject
    DataStore ds;

    public String getMessage() {
        SomeEntity se = new SomeEntity("duke " + System.currentTimeMillis());
        ds.saveOrUpdate(se);
        ds.update(se.getName());
        return se.toString();
    }
}
