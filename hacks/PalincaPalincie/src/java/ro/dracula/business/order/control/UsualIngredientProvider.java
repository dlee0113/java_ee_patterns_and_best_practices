package ro.dracula.business.order.control;

//@DrinkingLevel(DrinkingLevel.Level.GERMAN)
public class UsualIngredientProvider implements IngredientsProvider{

    @Override
    public String getIngredients() {
        return "55% alc";
    }

}
