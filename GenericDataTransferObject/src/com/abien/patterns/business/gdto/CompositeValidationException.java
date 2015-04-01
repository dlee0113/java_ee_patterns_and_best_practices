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

* Copyright (c) 23. September 2009 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.patterns.business.gdto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Adam Bien, www.adam-bien.com
 */

public class CompositeValidationException extends Exception{
    private Map<String,ValidationException> validationExceptions;
    private String gdtoName = null;
    
    public CompositeValidationException(String gdtoName) {
        super("ValidationError in: " + gdtoName);
        this.validationExceptions = new HashMap<String,ValidationException>();
        this.gdtoName = gdtoName;
    }
    
    
    public void add(String attributeName,ValidationException validationException){
        this.validationExceptions.put(attributeName,validationException);
    }
    
    public Map<String,ValidationException> getValidationExceptions(){
        return this.validationExceptions;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("GDTO Name: ").append(this.gdtoName);
        Set<Map.Entry<String,ValidationException>> exceptions =   this.validationExceptions.entrySet();
        Iterator<Map.Entry<String,ValidationException>> exceptionIterator = exceptions.iterator();
        while(exceptionIterator.hasNext()){
            Map.Entry<String,ValidationException> entry = exceptionIterator.next();
            result.append("Name: ").append(entry.getKey()).append(" Message: ").append(entry.getValue().getMessage());
        }
        return result.toString();
    }
    
    public boolean isEmpty(){
        return this.validationExceptions.isEmpty();
    }
}
