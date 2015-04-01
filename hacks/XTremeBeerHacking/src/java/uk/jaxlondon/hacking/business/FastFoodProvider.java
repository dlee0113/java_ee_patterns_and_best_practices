/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

/**
 *
 * @author abien
 */
@Food(Food.Quality.LOW)
public class FastFoodProvider implements BeverageProvider{

    @Override
    public String getFood() {
        return "Burger";
    }
    
}
