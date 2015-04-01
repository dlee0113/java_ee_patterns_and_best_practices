package de.berlin.dojorn.business.tasks.control;

import de.berlin.dojorn.business.tasks.entity.Task;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class DescriptionFormatter implements Formatter {
   
    @Override
    public Task format(Task task){
       task.setDescription("merry x-mas");
       return task;
    }

    @Override
    public void withName(String name) {
        System.out.println("---- " + name);
    }
}
