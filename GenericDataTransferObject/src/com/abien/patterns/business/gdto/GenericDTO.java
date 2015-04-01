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

import com.abien.patterns.business.gdto.types.FloatType;
import com.abien.patterns.business.gdto.types.IntType;
import com.abien.patterns.business.gdto.types.StringType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import static com.abien.patterns.business.gdto.Assert.*;

public class GenericDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Map<String, Attribute> attributes = null;
    private Map<String, Set<GenericDTO>> relations = null;
    private String name = null;

    public GenericDTO(String name) {
        notNull(name, "The name of the DTO cannot be null...");
        this.attributes = new HashMap<String, Attribute>();
        this.relations = new HashMap<String, Set<GenericDTO>>();
        this.name = name;
    }

    public GenericDTO add(String name, Attribute attribute) {
        notNull(name, "Attribute name cannot be null");
        notNull(attribute, "Attribute with name: " + name + " is null!");
        this.attributes.put(name, attribute);
        return this;
    }

    public GenericDTO addString(String name, String value) {
        notNull(name, "Attribute name cannot be null");
        notNull(value, "Attribute with name: " + name + " is null!");
        this.attributes.put(name, new StringType(null,value));
        return this;
    }

    public GenericDTO addInt(String name, int value) {
        notNull(name, "Attribute name cannot be null");
        notNull(value, "Attribute with name: " + name + " is null!");
        this.attributes.put(name, new IntType(null,String.valueOf(value)));
        return this;
    }
   public GenericDTO addFloat(String name, float value) {
        notNull(name, "Attribute name cannot be null");
        notNull(value, "Attribute with name: " + name + " is null!");
        this.attributes.put(name, new FloatType(null,String.valueOf(value)));
        return this;
    }


    public GenericDTO remove(String name) {
        notNull(name, "Attribute name cannot be null");
        this.attributes.remove(name);
        return this;
    }

    public GenericDTO addRelation(String relationName, GenericDTO genericDTO) {
        notNull(relationName, "The name of the relation cannot be null !");
        notNull(genericDTO, "The target cannot for the relation with name " + relationName + " be null");
        addTarget(relationName, genericDTO);
        return this;
    }

    private GenericDTO addTarget(String relationName, GenericDTO target) {
        Set<GenericDTO> targets = this.relations.get(relationName);
        if (targets == null) {
            targets = new HashSet<GenericDTO>();
            this.relations.put(relationName, targets);
        }
        targets.add(target);
        return this;
    }

    public Attribute get(String name) {
        notNull(name, "Attribute name cannot be null");
        return this.attributes.get(name);
    }

    public Set<GenericDTO> getTargets(String name) {
        notNull(name, "The name of the relation cannot be null !");
        return this.relations.get(name);
    }

    public GenericDTO getTarget(String name) {
        notNull(name, "The name of the relation cannot be null !");
        return this.relations.get(name).iterator().next();
    }

    public Iterator<String> getAttributeNames() {
        return this.attributes.keySet().iterator();
    }

    public Iterator<String> getRelationNames() {
        return this.relations.keySet().iterator();
    }

    public Iterator<Attribute> getAttributes() {
        return this.attributes.values().iterator();
    }

    public Iterator<Set<GenericDTO>> getTargets() {
        return this.relations.values().iterator();
    }

    public GenericDTO validate() throws CompositeValidationException {
        Set<Map.Entry<String, Attribute>> attibuteEntries = this.attributes.entrySet();
        Iterator<Map.Entry<String, Attribute>> attributeIterator = attibuteEntries.iterator();
        CompositeValidationException compositeValidationException = new CompositeValidationException(this.name);
        Map.Entry<String, Attribute> entry = null;
        while (attributeIterator.hasNext()) {
            try {
                entry = attributeIterator.next();
                Attribute attributeEntry = entry.getValue();
                attributeEntry.validate();
            } catch (ValidationException ex) {
                compositeValidationException.add(entry.getKey(), ex);
            }
            //some validation errors occured  
            if (!compositeValidationException.isEmpty()) {
                throw compositeValidationException;
            }

        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("GDTO Name: ").append(this.name);
        result.append("\n").append("--- attributes ---").append("\n");
        Set<Map.Entry<String, Attribute>> attibuteEntries = this.attributes.entrySet();
        Iterator<Map.Entry<String, Attribute>> attributeIterator = attibuteEntries.iterator();
        while (attributeIterator.hasNext()) {
            Map.Entry<String, Attribute> entry = attributeIterator.next();
            result.append(" Name: ").append(entry.getKey()).append(" Content: ").append(entry.getValue().getValue());
        }
        return result.toString();
    }

    public Attribute getId() {
        Iterator<Attribute> iterator = this.getAttributes();
        while (iterator.hasNext()) {
            Attribute attribute = iterator.next();
            if (attribute.isId()) {
                return attribute;
            }
        }
        return null;
    }

    public int getNumberOfAttributes() {
        return this.attributes.size();
    }

    public boolean isEmpty() {
        return (this.attributes.isEmpty() && this.relations.isEmpty());
    }
}
