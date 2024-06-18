package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;

public class IngredientTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Ingredient mockIngredient;

    @Test
    public void testIngredientName () {
        Mockito.when(mockIngredient.getName()).thenReturn("Test");
        Assert.assertEquals("Test", mockIngredient.getName());
    }

    @Test
    public void testIngredientPrice () {
        Mockito.when(mockIngredient.getPrice()).thenReturn(1.11f);
        Assert.assertEquals(1.11f, mockIngredient.getPrice(),0);
    }


}
