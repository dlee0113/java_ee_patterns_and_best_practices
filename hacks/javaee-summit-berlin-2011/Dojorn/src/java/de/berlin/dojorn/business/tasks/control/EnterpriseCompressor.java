package de.berlin.dojorn.business.tasks.control;

import de.berlin.dojorn.business.tasks.entity.Task;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Specializes
public class EnterpriseCompressor extends Compressor{

    @Override
    public void compress(Task task) {
        super.compress(task);
        System.out.println("***** " + task);
    }
    
}
