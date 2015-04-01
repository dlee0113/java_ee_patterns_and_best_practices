/**
 * This file is part of javaee-patterns.
 *
 * javaee-patterns is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 *
 * javaee-patterns is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.
 *
 * Copyright (c) 12. October 2009 Adam Bien, blog.adam-bien.com
 * http://press.adam-bien.com
 */
package com.abien.patterns.business.fluidlogic;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("calculator/")
public class Calculator {

    private static final String ENGINE_NAME = "JavaScript";
    private ScriptEngine scriptEngine = null;

    @PostConstruct
    public void initScripting() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        this.scriptEngine = engineManager.getEngineByName(ENGINE_NAME);
        if (this.scriptEngine == null) {
            throw new IllegalStateException("Cannot create ScriptEngine: " + ENGINE_NAME);
        }
    }

    @GET
    @Path("{formula}/")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculate(@PathParam("formula") String formula) {
        Object retVal = null;
        try {
            Bindings binding = this.scriptEngine.createBindings();
            binding.put("FIVE", 5);
            binding.put("API", new API());
            binding.put("A1", new BigDecimal(1));
            binding.put("A2", new BigDecimal(2));
            long start = System.currentTimeMillis();
            try {
                retVal = this.scriptEngine.eval(formula, binding);
            } finally {
                System.out.println("Performance: " + (System.currentTimeMillis() - start));
            }
        } catch (Exception e) {
            throw new IllegalStateException("Exception during evaluating script: " + e, e);
        }
        return retVal.toString();
    }
}
