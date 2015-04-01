package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Result;

/**
 *
 * @author Adam Bien, blog.adam-bien.com
 */
public class Blogger implements Consultant{

    @Override
    public Result predictFutureOfJava() {
        return Result.JAVA_IS_DEAD;
    }
    
}
