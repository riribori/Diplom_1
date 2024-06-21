package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredients;

    @Test
    public  void testSetBun () {
        Burger burger = new Burger (); // создаем бургер
        float price = 323.3f;
        Bun bun = new Bun("testy bun", price); //создаем булку
        burger.setBuns(bun); // кладем булку в бургер
        assertEquals("Булка снова не добавилась", "testy bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient (){
        Burger burger = new Burger ();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Mazik", 6.5f);
        // Добавляем ингредиент к рецепту
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        // Проверяем, что ингредиент был добавлен
         assertTrue("Ингредиент 1 не добавился", burger.ingredients.contains(ingredient1)); // проверяем что список ингредиентов в бургере содержит созданный ингр-ент
         assertTrue("Ингредиент 2 не добавился", burger.ingredients.contains(ingredient2));
       //  assertEquals(ingredient2, burger.ingredients.get(1)); - пример через ассерт иквлс
    }

    @Test
    public void testRemoveIndex () {
        Burger burger = new Burger ();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient (){
        Burger burger = new Burger ();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Mazik", 6.5f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice (){
        Burger burger = new Burger ();
        float ingredientPrice = 1.11f;
        Mockito.when(mockIngredients.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(mockIngredients);
        burger.addIngredient(mockIngredients);
        float bunPrice = 1.11f;
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(mockBun);
        burger.getPrice();
        float price = bunPrice * 2 + ingredientPrice + ingredientPrice;
        assertEquals("Цена различается", price, burger.getPrice(),0);
    }

    @Test
    public void testGetReceipt (){
        Burger burger = new Burger ();
        String ingredientName = "Tomato Sauce";
        String bunName = "testy bun";
        float ingredientPrice = 1.11f;
        float bunPrice = 1.11f;
        IngredientType ingredientType = IngredientType.SAUCE;
        Mockito.when(mockIngredients.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredients.getName()).thenReturn(ingredientName);
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockIngredients.getType()).thenReturn(ingredientType);
      //  Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        burger.addIngredient(mockIngredients);
      //  Bun bun = new Bun("testy bun",22.3f); //создаем булку
        burger.setBuns(mockBun);
        assertTrue("Булка не добавилась", burger.getReceipt().contains(bunName));
        assertTrue("Ингредиент не добавился", burger.getReceipt().contains(ingredientName));
        assertTrue("Цена не добавилась", burger.getReceipt().contains(String.format("%nPrice: %f%n", burger.getPrice())));
    }
}


