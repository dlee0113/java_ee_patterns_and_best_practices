package com.abien.patterns.business.sf;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;

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

* Copyright (c) 21. June 2010 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
@SessionScoped
public class CurrentTime implements Serializable{
    
    private static AtomicInteger instanceCount = new AtomicInteger(0);
    
    @PostConstruct
    public void onNewSession(){
        instanceCount.incrementAndGet();
    }
    
    public int getNumberOfSessions(){
        return instanceCount.get();
    }
    
    public long nanos(){
        return System.nanoTime();
    }
}
