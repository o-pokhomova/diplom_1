package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class BugrerAddIngredientMockTest {
    private Burger burger;
    private List<Ingredient> ingredients;
    public final Ingredient ingredient = MockBurgerUtils.mockIngredient(
            IngredientType.FILLING,
            "Секретный ингрeдиент",
            25f
    );

    @Before
    public void setUp() {
        ingredients = mock(List.class);
        burger = new Burger();
        burger.ingredients = ingredients;
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        verify(ingredients).add(eq(ingredient));
    }

    @Test
    public void addIngredientFailedThrowsException() {
        when(ingredients.add(eq(ingredient))).thenThrow(IllegalStateException.class);

        Assert.assertThrows(IllegalStateException.class, () -> burger.addIngredient(ingredient));
    }

    @Test
    public void addIngredientFailedVerifyAdd() {
        when(ingredients.add(eq(ingredient))).thenThrow(IllegalStateException.class);

        try {
            burger.addIngredient(ingredient);
        } catch (Exception e) {
            // Ничего не делаем, ожидаем проверку моков
        }
        verify(ingredients).add(eq(ingredient));
    }
}
