/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.dracula.business.order.control;

/**
 *
 * @author abien
 */
//@DrinkingLevel(DrinkingLevel.Level.ADVANCED)
public class XtremeIngredientProvider implements IngredientsProvider {

    @Override
    public String getIngredients() {
        return "80% alc";
    }

}
