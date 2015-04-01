package com.abien.business.patterns.bridgeplugin;

import com.abien.business.patterns.bridgeplugin.deserializers.Deserializer;
import com.abien.business.patterns.bridgeplugin.serializers.Serializer;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Model
public class Index {
    
    @Inject
    Serializer serializer;

    @Inject
    Deserializer deserializer;
    
    public String getMessage(){
        String msg = "duke";
        byte[] serialize = serializer.serialize(msg);
        return (String) deserializer.deserialize(serialize) + " with " + serializer.getClass();
    }
    
}
