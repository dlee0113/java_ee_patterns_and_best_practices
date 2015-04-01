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
package com.abien.business.patterns.customscope.control;

import com.abien.business.patterns.customscope.scope.ManualScoped;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@ManualScoped
public class AnotherControl {
    public final static AtomicInteger INSTANCE_COUNTER = new AtomicInteger(0);
    
    @PostConstruct
    public void onCreate(){
        INSTANCE_COUNTER.incrementAndGet();
    }

    public String execute(){
        return "+";
    }
    
    @PreDestroy
    public void onDestroy(){
        System.out.println(this.getClass().getName() + " onDestroy");
        INSTANCE_COUNTER.decrementAndGet();
    }
}
