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

* Copyright (c) 05. September 2010 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.integration.genericjca.spi;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.resource.ResourceException;
import javax.resource.spi.*;
import javax.security.auth.Subject;

public class GenericManagedConnectionFactory
        implements ManagedConnectionFactory, Serializable {

    private PrintWriter out;

    public GenericManagedConnectionFactory() {
        out = new PrintWriter(System.out);
        out.println("#GenericManagedConnectionFactory.constructor");
    }

    public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
        out.println("#GenericManagedConnectionFactory.createConnectionFactory,1");
        return new FileDataSource(out,this, cxManager);
    }

    public Object createConnectionFactory() throws ResourceException {
        out.println("#GenericManagedConnectionFactory.createManagedFactory,2");
        return new FileDataSource(out,this, null);
    }

    public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo info) {
        out.println("#GenericManagedConnectionFactory.createManagedConnection");
        return new GenericManagedConnection(out,this, info);
    }

    public ManagedConnection matchManagedConnections(Set connectionSet, Subject subject, ConnectionRequestInfo info)
            throws ResourceException {
        out.println("#GenericManagedConnectionFactory.matchManagedConnections Subject " + subject + " Info: " +  info);
        for (Iterator it = connectionSet.iterator(); it.hasNext();) {
            GenericManagedConnection gmc = (GenericManagedConnection) it.next();
            ConnectionRequestInfo connectionRequestInfo = gmc.getConnectionRequestInfo();
            if((info == null) || connectionRequestInfo.equals(info))
                return gmc;
        }
        throw new ResourceException("Cannot find connection for info!");
    }

    public void setLogWriter(PrintWriter out) throws ResourceException {
        out.println("#GenericManagedConnectionFactory.setLogWriter");
        this.out = out;
    }

    public PrintWriter getLogWriter() throws ResourceException {
        out.println("#GenericManagedConnectionFactory.getLogWriter");
        return this.out;
    }

}
