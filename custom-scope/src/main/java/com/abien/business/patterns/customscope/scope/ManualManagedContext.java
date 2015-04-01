/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

* Copyright (c) 23.07.2012, Adam Bien, adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.business.patterns.customscope.scope;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class ManualManagedContext implements Context {

    private ConcurrentHashMap<String, CDIBean> context = null;
    private final static ManualManagedContext INSTANCE = new ManualManagedContext();
    private boolean active;

    private ManualManagedContext() {
        this.context = new ConcurrentHashMap<String, CDIBean>();
        this.active = true;
    }

    public static ManualManagedContext getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return ManualScoped.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        System.out.println("Context: " + this.context + " Contextual " + contextual + " CreationalContext: " + creationalContext);
        Bean bean = (Bean) contextual;
        final String beanName = bean.getBeanClass().getName();
        T foundBean = get(contextual);
        if (foundBean != null) {
            return foundBean;
        } else {
            final CDIBean cdiBean = new CDIBean(contextual, creationalContext);
            this.context.put(beanName, cdiBean);
            return (T)cdiBean.getBean();
        }
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        System.out.println("---Contextual: " + contextual);
        final String beanName = ((Bean)contextual).getBeanClass().getName();
        final CDIBean cdiBean = context.get(beanName);
        if(cdiBean == null)
            return null;
        return (T) cdiBean.getBean();
    }

    @Override
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, CDIBean> getBeanContext() {
        return context;
    }
    
    public void shutdown(){
        for (CDIBean contextual : context.values()) {
            contextual.destroy();
        }
        this.context.clear();
    }
}
