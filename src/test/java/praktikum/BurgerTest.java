package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        Bun bun = Mockito.mock(Bun.class);

        burger.setBuns(bun);

        Assert.assertEquals("Не получилось установить булочку", bun, burger.bun);
    }

    @Test
    public void getPriceOfEmptyBurger() {
        Assert.assertThrows(
                "Бургер без булочек не считается бургером",
                NullPointerException.class,
                () -> burger.getPrice()
        );
    }

    @Test
    public void getReceiptOfEmptyBurger() {
        Assert.assertThrows(
                "Бургер без булочек не считается бургером",
                NullPointerException.class,
                () -> burger.getReceipt()
        );
    }
}