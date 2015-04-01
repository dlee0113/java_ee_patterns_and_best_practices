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
package com.abien.patterns.integration.genericjca.client;

import com.abien.patterns.integration.genericjca.Connection;
import com.abien.patterns.integration.genericjca.DataSource;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author adam-bien.com
 */
@Stateless
@WebService
public class JCAClientBean implements JCAClientRemote {

    @Resource(mappedName="jca/FileFactory")
    private DataSource dataSource;

    @Resource
    private SessionContext context;

    public void accessFile(String content){
            Connection connection = dataSource.getConnection();
            connection.write(content);
            connection.close();
    }

    public void accessFileAndRollback(String content){
            Connection connection = dataSource.getConnection();
            connection.write(content);
            context.setRollbackOnly();
    }

    public void accessFileAndThrowException(String content){
            Connection connection = dataSource.getConnection();
            connection.write(content);
            throw new RuntimeException("Force Rollback");
    }
}


