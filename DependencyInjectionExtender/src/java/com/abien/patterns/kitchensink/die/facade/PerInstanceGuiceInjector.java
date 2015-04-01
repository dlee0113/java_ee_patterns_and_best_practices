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

* Copyright (c) 04. November 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.kitchensink.die.facade;

import com.abien.patterns.kitchensink.die.guice.MessagingModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.annotation.PostConstruct;
import javax.interceptor.InvocationContext;

/**
 * @author adam-bien.com
 */
public class PerInstanceGuiceInjector{

    @PostConstruct
    public void startAndInject(InvocationContext invocationContext) throws Exception{
      invocationContext.proceed();
      Injector injector = Guice.createInjector(new MessagingModule());
      injector.injectMembers(invocationContext.getTarget());
    }
}
