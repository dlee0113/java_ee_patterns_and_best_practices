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

import com.abien.patterns.integration.genericjca.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;

public class FileConnection implements Connection, LocalTransaction{

    private String buffer;
    private FileOutputStream fileOutputStream;
    private ConnectionRequestInfo connectionRequestInfo;
    public final static String FILE_NAME = "/temp/jcafile.txt";
    private GenericManagedConnection genericManagedConnection;
    private PrintWriter out;

    public FileConnection(PrintWriter out,GenericManagedConnection genericManagedConnection,ConnectionRequestInfo connectionRequestInfo) {
        this.out = out;
        out.println("#FileConnection " + connectionRequestInfo + " " +toString());
        this.genericManagedConnection = genericManagedConnection;
        this.connectionRequestInfo = connectionRequestInfo;
        this.initialize();
    }

    private void initialize(){
        try {
            this.buffer = null;
            this.fileOutputStream = new FileOutputStream(FILE_NAME,true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Cannot initialize OutputStream: " + FILE_NAME);
        }

    }

    public void write(String content) {
        out.println("#FileConnection.write " + content);
        this.buffer = content;
    }

    public void close() {
            this.genericManagedConnection.close();
    }

    public void destroy(){
        out.println("#FileConnection.cleanup");
        try {
            if(this.fileOutputStream != null)
                this.fileOutputStream.close();
          this.fileOutputStream = null;
          this.buffer = null;
         } catch (IOException ex) {
            Logger.getLogger(FileConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Cannot close stream: " +ex,ex);
        }
    }

    public void begin() throws ResourceException {
        out.println("#FileConnection.begin " +toString());
        this.initialize();
    }

    public void commit() throws ResourceException {
        out.println("#FileConnection.commit "  +toString());
        try {
         this.fileOutputStream.write(this.buffer.getBytes());
         this.fileOutputStream.flush();
         this.fileOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResourceException(ex);
        }
    }

    public void rollback() throws ResourceException {
        out.println("#FileConnection.rollback  " +toString());
        this.buffer = null;
        try {
            this.fileOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResourceException(ex);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileConnection other = (FileConnection) obj;
        if (this.connectionRequestInfo != other.connectionRequestInfo && (this.connectionRequestInfo == null || !this.connectionRequestInfo.equals(other.connectionRequestInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.connectionRequestInfo != null ? this.connectionRequestInfo.hashCode() : 0);
        return hash;
    }
}
