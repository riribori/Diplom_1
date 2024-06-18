package test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)

public class IngredientParameterizedTest {

    private IngredientType ingredientType;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

   public IngredientParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
   }


    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "Test", 32.3f);
        Assert.assertEquals("Тип ингредиента не получен",ingredientType, ingredient.getType());
    }
}



