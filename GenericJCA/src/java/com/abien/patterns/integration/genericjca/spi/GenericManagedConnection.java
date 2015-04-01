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
import java.util.LinkedList;
import java.util.List;
import javax.resource.ResourceException;
import javax.resource.spi.LocalTransaction;
import static javax.resource.spi.ConnectionEvent.*;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public class GenericManagedConnection
        implements ManagedConnection, LocalTransaction {

    private ManagedConnectionFactory mcf;
    private PrintWriter out;
    private FileConnection fileConnection;
    private ConnectionRequestInfo connectionRequestInfo;
    private List<ConnectionEventListener> listeners;

    GenericManagedConnection(PrintWriter out,ManagedConnectionFactory mcf, ConnectionRequestInfo connectionRequestInfo) {
        this.out = out;
        out.println("#GenericManagedConnection");
        this.mcf = mcf;
        this.connectionRequestInfo = connectionRequestInfo;
        this.listeners = new LinkedList<ConnectionEventListener>();
    }

    public Object getConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo)
            throws ResourceException {
        out.println("#GenericManagedConnection.getConnection");
        fileConnection = new FileConnection(out,this, connectionRequestInfo);
        return fileConnection;
    }

    public void destroy() {
        out.println("#GenericManagedConnection.destroy");
        this.fileConnection.destroy();
    }

    public void cleanup() {
        out.println("#GenericManagedConnection.cleanup");
    }

    public void associateConnection(Object connection) {
        out.println("#GenericManagedConnection.associateConnection " + connection);
        this.fileConnection = (FileConnection) connection;

    }

    public void addConnectionEventListener(ConnectionEventListener listener) {
        out.println("#GenericManagedConnection.addConnectionEventListener");
        this.listeners.add(listener);
    }

    public void removeConnectionEventListener(ConnectionEventListener listener) {
        out.println("#GenericManagedConnection.removeConnectionEventListener");
        this.listeners.remove(listener);
    }

    public XAResource getXAResource()
            throws ResourceException {
        out.println("#GenericManagedConnection.getXAResource");
        return null;
    }

    public LocalTransaction getLocalTransaction() {
        out.println("#GenericManagedConnection.getLocalTransaction");
        return this;
    }

    public ManagedConnectionMetaData getMetaData()
            throws ResourceException {
        out.println("#GenericManagedConnection.getMetaData");
        return new ManagedConnectionMetaData() {

            public String getEISProductName()
                    throws ResourceException {
                out.println("#MyConnectionMetaData.getEISProductName");
                return "Generic JCA";
            }

            public String getEISProductVersion()
                    throws ResourceException {
                out.println("#MyConnectionMetaData.getEISProductVersion");
                return "1.0";
            }

            public int getMaxConnections()
                    throws ResourceException {
                out.println("#MyConnectionMetaData.getMaxConnections");
                return 5;
            }

            public String getUserName()
                    throws ResourceException {
                return null;
            }
        };
    }

    public void setLogWriter(PrintWriter out)
            throws ResourceException {
        System.out.println("#GenericManagedConnection.setLogWriter");
        this.out = out;
    }

    public PrintWriter getLogWriter()
            throws ResourceException {
        System.out.println("#GenericManagedConnection.getLogWriter");
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericManagedConnection other = (GenericManagedConnection) obj;
        if (this.connectionRequestInfo != other.connectionRequestInfo && (this.connectionRequestInfo == null || !this.connectionRequestInfo.equals(other.connectionRequestInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.connectionRequestInfo != null ? this.connectionRequestInfo.hashCode() : 0);
        return hash;
    }

    public ConnectionRequestInfo getConnectionRequestInfo() {
        return connectionRequestInfo;
    }

    public void begin() throws ResourceException {
        this.fileConnection.begin();
        this.fireConnectionEvent(LOCAL_TRANSACTION_STARTED);
    }

    public void commit() throws ResourceException {
        this.fileConnection.commit();
        this.fireConnectionEvent(LOCAL_TRANSACTION_COMMITTED);
    }

    public void rollback() throws ResourceException {
        this.fileConnection.rollback();
        this.fireConnectionEvent(LOCAL_TRANSACTION_ROLLEDBACK);
    }

    public void fireConnectionEvent(int event) {
        ConnectionEvent connnectionEvent = new ConnectionEvent(this, event);
        connnectionEvent.setConnectionHandle(this.fileConnection);
        for (ConnectionEventListener listener : this.listeners) {
            switch (event) {
                case LOCAL_TRANSACTION_STARTED:
                    listener.localTransactionStarted(connnectionEvent);
                    break;
                case LOCAL_TRANSACTION_COMMITTED:
                    listener.localTransactionCommitted(connnectionEvent);
                    break;
                case LOCAL_TRANSACTION_ROLLEDBACK:
                    listener.localTransactionRolledback(connnectionEvent);
                    break;
                case CONNECTION_CLOSED:
                    listener.connectionClosed(connnectionEvent);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown event: " + event);
            }
        }
    }

    public void close() {
        this.fireConnectionEvent(CONNECTION_CLOSED);
    }
}
