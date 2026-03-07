package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class BugrerAddIngredientMockTest {
    public static final Ingredient INGREDIENT = new Ingredient(IngredientType.FILLING, "Секретный ингрeдиент", 25f);
    private Burger burger;
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        ingredients = mock(List.class);
        burger = new Burger();
        burger.ingredients = ingredients;
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(INGREDIENT);
        verify(ingredients).add(eq(INGREDIENT));
    }

    @Test
    public void addIngredientFailed() {
        when(ingredients.add(eq(INGREDIENT))).thenThrow(IllegalStateException.class);

        Assert.assertThrows(IllegalStateException.class, () -> burger.addIngredient(INGREDIENT));
        verify(ingredients).add(eq(INGREDIENT));
    }
}
