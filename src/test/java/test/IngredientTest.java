package test;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    String name = "Tomato";
    float price = 33.33f;
    IngredientType ingredientType = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient( ingredientType, name,  price);


    @Test
    public void testIngredientName () {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testIngredientPrice () {
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }

    @Test
    public void testIngredientType () {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

}
