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

import com.abien.business.patterns.customscope.control.Control;
import com.abien.business.patterns.customscope.scope.ManualManagedContext;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@RequestScoped
public class InjectionBoundary {
    
    @Inject 
    Control first;

    @Inject 
    Control second;
    
    @Inject
    Instance<Control> firstInstance;

    @Inject 
    Instance<Control> secondInstance;
    
    public String invokeService(){
        return first.execute();
    }
    
    public boolean sameInstance(){
        return first == second;
    }
    
    public boolean lazyFetch(){
        return firstInstance.get() == secondInstance.get();
    }
    
    public boolean differentLazyInstance(){
        Control lazyFirst = firstInstance.get();
        ManualManagedContext.getInstance().shutdown();
        Control lazySecond = secondInstance.get();
        return lazyFirst != lazySecond;
    }
    
    public String injectedAsString(){
        return first.toString() + " | " + second.toString();
    }
    
    @PreDestroy
    public void onDestroy(){
        System.out.println(this.getClass().getName() + " onDestroy");
    }    
}
