package de.berlin.dojorn.business.tasks.control;

import de.berlin.dojorn.business.tasks.entity.Task;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public interface Formatter {
    public void withName(String name);
    Task format(Task task);
    
}
