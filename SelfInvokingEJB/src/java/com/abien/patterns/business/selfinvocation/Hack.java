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

* Copyright (c) 19. February 2012 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.selfinvocation;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Named;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
@Named
@Stateless
public class Hack {
    
    @Resource
    SessionContext sc;
    
    Hack me;
    
    @PostConstruct
    public void init(){
        this.me = this.sc.getBusinessObject(Hack.class);
    }

    @TransactionAttribute(value= TransactionAttributeType.NOT_SUPPORTED)
    public String boundaryMethodWithoutAspects(){
        this.expectsException();
        return "...just an ordinary call";
    }
    
    @TransactionAttribute(value= TransactionAttributeType.NOT_SUPPORTED)
    public String boundaryMethodWithAspects(){
        try{
            this.me.expectsException();
            return "...exception expected :-(";
        }catch(EJBTransactionRequiredException e){
            return "Works! : " + e;
        }
    }
    
    @TransactionAttribute(value= TransactionAttributeType.MANDATORY)
    public void expectsException(){
        System.out.println("Should not appear in the log");
    }
}
