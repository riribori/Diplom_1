package test;

import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
public class BurgerTest {

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
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Mazik", 6.5f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Bun bun = new Bun("testy bun",22.3f); //создаем булку
        burger.setBuns(bun);
        burger.getPrice();
        float price = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals("Цена различается", price, burger.getPrice(),0);
    }

    @Test
    public void testGetReceipt (){
        Burger burger = new Burger ();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Tomato Sauce", 2.5f);
        burger.addIngredient(ingredient);
        Bun bun = new Bun("testy bun",22.3f); //создаем булку
        burger.setBuns(bun);
        assertTrue("Булка не добавилась", burger.getReceipt().contains("testy bun"));
        assertTrue("Ингредиент не добавился", burger.getReceipt().contains("Tomato Sauce"));
        assertTrue("Цена не добавилась", burger.getReceipt().contains(String.format("%nPrice: %f%n", burger.getPrice())));
    }
}


