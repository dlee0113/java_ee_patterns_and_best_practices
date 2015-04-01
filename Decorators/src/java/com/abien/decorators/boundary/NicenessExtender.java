package com.abien.decorators.boundary;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Decorator
public abstract class NicenessExtender implements Messenger{

    @Inject @Delegate
    private Messenger messenger;
    
    @Override
    public String morning() {
        return "Good " + messenger.morning();
    }
}
