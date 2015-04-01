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

* Copyright (c) 04. August 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.kitchensink;

import java.util.Properties;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * Hides and simplifies the access to objects stored in the JNDI-tree.
 * 
 * @author Adam Bien, www.adam-bien.com
 */
public class BeanLocator {

    public static class GlobalJNDIName {

        private StringBuilder builder;
        private final static String PREFIX = "java:global";
        private final static String SEPARATOR = "/";
        private final static String PROPERTY_FILE = "/global.jndi";
        private final static String MODULE_NAME_KEY = "module.name";
        private final static String APP_NAME_KEY = "application.name";
        private Properties globalConfiguration;
        private String appName;
        private String moduleName;
        private String beanName;
        private String businessInterfaceName;

        public GlobalJNDIName() {
            this.builder = new StringBuilder();
            this.builder.append(PREFIX).append(SEPARATOR);
            this.globalConfiguration = new Properties();
            try {
                this.globalConfiguration.load(this.getClass().getResourceAsStream(PROPERTY_FILE));
            } catch (Exception ex) {
                System.out.println("Cannot load configuration: " + ex);
            }
            this.appName = this.globalConfiguration.getProperty(APP_NAME_KEY);
            this.moduleName = this.globalConfiguration.getProperty(MODULE_NAME_KEY);
        }

        public GlobalJNDIName withAppName(String appName) {
            this.appName = appName;
            return this;
        }

        public GlobalJNDIName withModuleName(String moduleName) {
            this.moduleName = moduleName;
            return this;
        }

        public GlobalJNDIName withBeanName(String beanName) {
            this.beanName = beanName;
            return this;
        }

        public GlobalJNDIName withBeanName(Class beanClass) {
            return withBeanName(computeBeanName(beanClass));
        }

        public GlobalJNDIName withBusinessInterface(Class interfaze) {
            this.businessInterfaceName = interfaze.getName();
            return this;
        }

        String computeBeanName(Class beanClass) {
            Stateless stateless = (Stateless) beanClass.getAnnotation(Stateless.class);
            if (stateless != null && isNotEmpty(stateless.name())) {
                return stateless.name();
            }
           Stateful stateful = (Stateful) beanClass.getAnnotation(Stateful.class);
            if (stateful != null && isNotEmpty(stateful.name())) {
                return stateful.name();
            }
            Singleton singleton = (Singleton) beanClass.getAnnotation(Singleton.class);
            if (singleton != null && isNotEmpty(singleton.name())) {
                return singleton.name();
            }
            return beanClass.getSimpleName();
        }

        private boolean isNotEmpty(String name){
            return (name != null && !name.isEmpty());
        }

        public String asString() {
            if (appName != null) {
                this.builder.append(appName).append(SEPARATOR);
            }
            this.builder.append(moduleName).append(SEPARATOR);
            this.builder.append(beanName);
            if (businessInterfaceName != null) {
                this.builder.append("#").append(businessInterfaceName);
            }
            return this.builder.toString();
        }

        public <T> T locate(Class<T> clazz) {
            return BeanLocator.lookup(clazz, asString());
        }

        public Object locate() {
             return BeanLocator.lookup(asString());
        }
    }

    /**
     * 
     * @param clazz the type (Business Interface or Bean Class)
     * @param jndiName the global JNDI name with the pattern: java:global[/<app-name>]/<module-name>/<bean-name>#<fully-qualified-
    interface-name>
     * @return The local or remote reference to the bean.
     */
    public static <T> T lookup(Class<T> clazz, String jndiName) {
            Object bean = lookup(jndiName);
            return clazz.cast(PortableRemoteObject.narrow(bean, clazz));
    }

    public static Object lookup(String jndiName) {
        Context context = null;
        try {
            context = new InitialContext();
            return context.lookup(jndiName);
        } catch (NamingException ex) {
            throw new IllegalStateException("Cannot connect to bean: " + jndiName + " Reason: " + ex, ex.getCause());
        } finally {
            try {
                context.close();
            } catch (NamingException ex) {
                throw new IllegalStateException("Cannot close InitialContext. Reason: " + ex, ex.getCause());
            }
        }
    }
}
