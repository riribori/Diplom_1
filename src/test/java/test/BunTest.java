package test;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {

    String name = "Spice Bun";
    float price = 11.33f;
    Bun bun = new Bun(name, price);

    @Test
    public void testBunName () {
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void testBunPrice () {
        Assert.assertEquals(price, bun.getPrice(),0);
    }

}
