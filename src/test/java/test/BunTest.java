package test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)

public class BunTest {

    @Mock
    private Bun mockBun;

    @Test
    public void testBinName () {
        Mockito.when(mockBun.getName()).thenReturn("Test");
        Assert.assertEquals("Test", mockBun.getName());
    }

    @Test
    public void testBinPrice () {
        Mockito.when(mockBun.getPrice()).thenReturn(1.11f);
        Assert.assertEquals(1.11f, mockBun.getPrice(),0);
    }

}
