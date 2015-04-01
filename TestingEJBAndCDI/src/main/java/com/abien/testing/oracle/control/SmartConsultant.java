package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Result;
import javax.enterprise.inject.Alternative;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
@Alternative
public class SmartConsultant implements Consultant{

    @Override
    public Result predictFutureOfJava() {
        return Result.IT_DEPENDS;
    }
    
}
