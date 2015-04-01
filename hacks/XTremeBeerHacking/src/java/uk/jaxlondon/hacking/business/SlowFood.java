/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.jaxlondon.hacking.business;

/**
 *
 * @author abien
 */
@Food(Food.Quality.HIGH)
public class SlowFood implements BeverageProvider{

    @Override
    public String getFood() {
        return "fish with chicken";
    }
    
}
