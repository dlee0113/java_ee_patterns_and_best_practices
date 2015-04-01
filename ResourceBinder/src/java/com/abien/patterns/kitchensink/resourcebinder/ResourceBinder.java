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

* Copyright (c) 02. November 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.kitchensink.resourcebinder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author adam-bien.com
 */
@Startup
@Singleton
public class ResourceBinder {
    @PostConstruct
    public void bindResources(){
        try {
            Context context = new InitialContext();
            context.rebind(CustomResource.JNDI_NAME, new CustomResource());
            System.out.println("Resource bound...");
            System.out.println(" " + context.lookup(CustomResource.JNDI_NAME));
        } catch (NamingException ex) {
            throw new IllegalStateException("Cannot bind resource " +ex,ex);
        }
    }
}
