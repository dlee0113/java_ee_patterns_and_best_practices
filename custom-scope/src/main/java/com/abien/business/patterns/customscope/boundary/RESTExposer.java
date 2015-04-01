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
package com.abien.business.patterns.customscope.boundary;

import com.abien.business.patterns.customscope.control.AnotherControl;
import com.abien.business.patterns.customscope.control.Control;
import com.abien.business.patterns.customscope.control.DependentControl;
import com.abien.business.patterns.customscope.scope.ManualManagedContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Stateless
@Path("customscope")
@Produces(MediaType.TEXT_PLAIN)
public class RESTExposer {

    @Inject
    InjectionBoundary tester;

    @GET
    @Path("injection")
    public String inject() {
        return tester.invokeService();
    }

    @GET
    @Path("beancontext")
    public String beanContext() {
        return ManualManagedContext.getInstance().getBeanContext().toString();
    }

    @GET
    @Path("sameinstance")
    public String sameInstance() {
        return tester.sameInstance() ? "+" : "-";
    }

    @GET
    @Path("samelazyinstance")
    public String sameLazyInstance() {
        return tester.lazyFetch() ? "+" : "-";
    }

    @GET
    @Path("shutdown")
    public String shutdown() {
        ManualManagedContext.getInstance().shutdown();
        return "+";
    }

    @GET
    @Path("injectedAsString")
    public String injectedAsString() {
        return tester.injectedAsString();
    }
    
    @GET
    @Path("instanceCount")
    public String instanceCount(){
        return AnotherControl.INSTANCE_COUNTER.intValue() + "" + Control.INSTANCE_COUNTER.intValue() + "" + DependentControl.INSTANCE_COUNTER.intValue();
    }
}
