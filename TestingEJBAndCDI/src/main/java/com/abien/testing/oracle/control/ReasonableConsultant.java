package com.abien.testing.oracle.control;

import com.abien.testing.oracle.entity.Result;
import javax.enterprise.inject.Alternative;

@Alternative
public class ReasonableConsultant implements Consultant{

    @Override
    public Result predictFutureOfJava() {
        return Result.BRIGHT;
    }
    
}
