package com.abien.business.patterns.configurator.presentation;

import com.abien.business.patterns.configurator.staging.Stage;
import java.util.Map;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author adam bien, blog.adam-bien.com
 */
@Model
public class FacesContextExposer {
    
    @Produces
    public Stage stage(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        return Stage.valueOf(ctx.getApplication().getProjectStage().name());
    }

    @Produces
    public Map<String,String> configuration(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        return ctx.getExternalContext().getInitParameterMap();
    }
}
