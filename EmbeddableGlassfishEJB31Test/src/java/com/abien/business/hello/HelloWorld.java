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

* Copyright (c) 26. September 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.business.hello;

import javax.ejb.Stateless;

/**
 *
 * @author http://blog.adam-bien.com
 */
@Stateless
public class HelloWorld {
    public String hello(String message){
        return "Echo: " + message;
    }
}
