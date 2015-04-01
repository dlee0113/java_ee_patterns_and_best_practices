
package com.abien.patterns.business.sf.hessian;

import com.abien.patterns.business.sf.CurrentTime;
import com.caucho.hessian.server.HessianServlet;
import javax.inject.Inject;

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
public class HessianTimeEndpoint extends HessianServlet implements TimeService{

    @Inject
    CurrentTime currentTime;

    @Override
    public long nanos() {
        return currentTime.nanos();
    }

    @Override
    public int getNumberOfSessions() {
        return currentTime.getNumberOfSessions();
    }
}
