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

* Copyright (c) 18. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.order.facade;

import com.abien.patterns.business.order.domain.Load;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author adam-bien.com
 */
@SessionScoped
@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class OrderGateway{

    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em;

    private Load current;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Load find(long id){
       this.current = this.em.find(Load.class, id);
       return this.current;
    }

    public Load getCurrent() {
        return current;
    }

    public void create(Load load){
        this.em.persist(load);
        this.current = load;
    }

    public void remove(long id){
        Load ref = this.em.getReference(Load.class, id);
        this.em.remove(ref);
    }
    
    public void pseudoUndo(){
        this.em.refresh(this.current);
    }    

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void save(){
        //nothing to do
    }
}
