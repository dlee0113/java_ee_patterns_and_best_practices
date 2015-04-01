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

* Copyright (c) 03. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.kitchensink;

import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam-bien.com
 */
public class BeanLocatorTest {

    @Test
    public void jndiName() {
        String expected = "java:global/appName/moduleName/beanName#java.io.Serializable";
        String actual = new BeanLocator.GlobalJNDIName().
                withAppName("appName").
                withModuleName("moduleName").
                withBeanName("beanName").withBusinessInterface(Serializable.class).asString();
        assertEquals(expected, actual);
    }

   @Test
    public void jndiNameWithConfiguration() {
        String expected = "java:global/BeanLocatorApp/BeanLocatorModule/beanName#java.io.Serializable";
        String actual = new BeanLocator.GlobalJNDIName().
                withBeanName("beanName").withBusinessInterface(Serializable.class).asString();
        assertEquals(expected, actual);
    }

    @Test
    public void jndiNameWithConfigurationWithoutBusinessInterface() {
        String expected = "java:global/BeanLocatorApp/BeanLocatorModule/beanName";
        String actual = new BeanLocator.GlobalJNDIName().
                withBeanName("beanName").asString();
        assertEquals(expected, actual);
    }

    @Test
    public void jndiNameWithConfigurationWithBeanClassWithoutBusinessInterface() {
        String expected = "java:global/BeanLocatorApp/BeanLocatorModule/StatelessWithCustomName";
        String actual = new BeanLocator.GlobalJNDIName().
                withBeanName(StatelessWithName.class).asString();
        assertEquals(expected, actual);
    }


}