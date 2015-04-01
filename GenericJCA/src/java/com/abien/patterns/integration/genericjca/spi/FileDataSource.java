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

import com.abien.patterns.integration.genericjca.*;
import java.io.PrintWriter;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnectionFactory;

public class FileDataSource
        implements DataSource {

    private ManagedConnectionFactory mcf;
    private Reference reference;
    private ConnectionManager cm;
    private PrintWriter out;

    public FileDataSource(PrintWriter out,ManagedConnectionFactory mcf, ConnectionManager cm) {
        out.println("#FileDataSource");
        this.mcf = mcf;
        this.cm = cm;
        this.out = out;
    }

    public FileConnection getConnection(){
        out.println("#FileDataSource.getConnection " + this.cm + " MCF: " + this.mcf);
        try {
            return (FileConnection) cm.allocateConnection(mcf, getConnectionRequestInfo());
        } catch (ResourceException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
   
    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Reference getReference() {
        return reference;
    }

    private ConnectionRequestInfo getConnectionRequestInfo() {
        return new ConnectionRequestInfo() {

            @Override
            public boolean equals(Object obj) {
                return true;
            }

            @Override
            public int hashCode() {
                return 1;
            }

        };
    }
}
