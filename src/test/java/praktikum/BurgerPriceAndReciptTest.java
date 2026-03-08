package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class BurgerPriceAndReciptTest {
    private static final float DELTA = 0.0001f;

    private final Burger burger = new Burger();
    private final float price;
    private final String receipt;

    public BurgerPriceAndReciptTest(
            Bun bun,
            Collection<Ingredient> ingredients,
            float price,
            String receipt
    ) {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        this.price = price;
        this.receipt = receipt;
    }


    @Parameterized.Parameters(name = "{2} {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{
                        MockBurgerUtils.mockBun(),
                        Collections.emptyList(),
                        40f,
                        "(==== Булочка с кунжутом ====)\n(==== Булочка с кунжутом ====)\n\nPrice: 40,000000\n"
                },
                new Object[]{
                        MockBurgerUtils.mockBun(),
                        Arrays.asList(
                                MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Котлета", 100f),
                                MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Сыр", 30f),
                                MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Маринованный огурец", 10f),
                                MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Томат", 20f),
                                MockBurgerUtils.mockIngredient(IngredientType.SAUCE, "Кетчуп", 5f),
                                MockBurgerUtils.mockIngredient(IngredientType.SAUCE, "Майонез", 5f)
                        ),
                        210f,
                        "(==== Булочка с кунжутом ====)\n= filling Котлета =\n= filling Сыр =\n= filling Маринованный огурец =\n= filling Томат =\n= sauce Кетчуп =\n= sauce Майонез =\n(==== Булочка с кунжутом ====)\n\nPrice: 210,000000\n"
                }
        );
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(
                price,
                burger.getPrice(),
                DELTA
        );
    }


    @Test
    public void getReceipt() {
        Assert.assertEquals(
                receipt,
                burger.getReceipt()
        );
    }

}
