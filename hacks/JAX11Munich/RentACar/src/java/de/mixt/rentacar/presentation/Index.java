package de.mixt.rentacar.presentation;

import de.mixt.rentacar.business.logging.boundary.Log;
import de.mixt.rentacar.business.rental.boundary.RentalService;
import de.mixt.rentacar.business.rental.entity.Vehicle;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Model
public class Index {
    
    @Inject
    Validator validator;
    
    @Inject
    RentalService rentalService;
    
    @Inject
    Log LOG;
    
    private Vehicle vehicle = new Vehicle();

    public Vehicle getVehicle() {
        return vehicle;
    }
    
    @PostConstruct
    public void initialize(){
        System.out.println("---Presenter initialization");
        LOG.info("Properly initialized");
    }
    
    
    public Object rent(){
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle, new Class[]{});
        for (ConstraintViolation<Vehicle> constraintViolation : violations) {
            System.out.println("Violation " + constraintViolation);
            FacesMessage facesMessage = new FacesMessage(constraintViolation.toString());
            FacesContext.getCurrentInstance().addMessage("42", facesMessage);
        }
        rentalService.rent(vehicle);
        System.out.println("Vehicle: " + vehicle);
        return null;
    }
    
    
}
