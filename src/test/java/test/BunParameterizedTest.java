package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)

public class BunParameterizedTest {

    private String bunName;
    private float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Black Bun", 3.0f},
                {"Sweet Bun", 5.5f},
                {"123", 5.0f},
                {null, 56.0f},
                {"", 57.0f},
                {"Bun with cheesе, chicken, bacon, beef and cucumber very testy", 8.0f},
                {"Special symbols #$%", 4.0f},
                {"Cheap bun", Float.MIN_VALUE},
                {"Expensive bun", Float.MAX_VALUE}
        };
    }

    public BunParameterizedTest(String bunName, float price) {
        this.bunName = bunName;
        this.price = price;
    }

    @Test
    public void testBunName() {
        Bun bun = new Bun(bunName, price);
        Assert.assertEquals("Имя булочки не получено", bunName, bun.getName());
    }

    @Test
    public void testBunPrice() {
        Bun bun = new Bun(bunName, price);
        Assert.assertEquals("Цена булочки не получена", price, bun.getPrice(), 0);
    }

}