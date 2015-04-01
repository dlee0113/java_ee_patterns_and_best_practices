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

* Copyright (c) 20. February 2010 Adam Bien, blog.adam-bien.com
* http://press.adam-bien.com
*/
package com.abien.business.timer.boundary;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

/**
 *
 * @author blog.adam-bien.com
 */
@Singleton
@Startup
public class PeriodicTimer {

    @Resource
    TimerService timerService;

    @PostConstruct
    public void initialize(){
        ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/1").minute("*").hour("*");
        timerService.createCalendarTimer(expression);
    }

    @Timeout
    public void execute(){
        System.out.println("----Invoked: " + System.currentTimeMillis());
    }
}
