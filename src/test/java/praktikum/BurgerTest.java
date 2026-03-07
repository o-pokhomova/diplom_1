package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {
    public static final Bun BUN = new Bun("Булочка с кунжутом", 20f);

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(BUN);

        Assert.assertEquals("Не получилось установить булочку", BUN, burger.bun);
    }

    @Test
    public void getPriceOfEmptyBurger() {
        Assert.assertThrows(
                "Бургер без булочек не считается бургером",
                NullPointerException.class,
                () ->  burger.getPrice()
        );
    }

    @Test
    public void getReceiptOfEmptyBurger() {
        Assert.assertThrows(
                "Бургер без булочек не считается бургером",
                NullPointerException.class,
                () ->  burger.getReceipt()
        );
    }
}