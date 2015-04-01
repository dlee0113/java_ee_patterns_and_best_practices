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

* Copyright (c) 24. June 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.hello;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam Bien (blog.adam-bien.com)
 */
public class HelloBeanTest {
    private Hello hello;

    @Before
    public void bootContainer() throws Exception{
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        Context context = new InitialContext(props);
        hello = (Hello) context.lookup("HelloBeanLocal");

    }

    @Test
    public void hello(){
        assertNotNull(hello);
        String message = "hugo";
        String echo = hello.hello(message);
        assertNotNull(echo);
        assertEquals(message,echo);
    }

    //only needed for profiling purposes
    public static void main(String[] args) throws Exception {
        new HelloBeanTest().hello();
    }

}