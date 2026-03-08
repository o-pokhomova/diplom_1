package praktikum;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerIngredientTest {
    private final Burger burger;
    private final Ingredient ingredient;

    public BurgerIngredientTest(IngredientType ingredientType) {
        burger = new Burger();
        ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<IngredientType> data() {
        return Arrays.asList(IngredientType.values());
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);

        Assertions.assertThat(burger.ingredients)
                .withFailMessage("Не удалось добавить ингрeдиент")
                .containsExactly(ingredient);
    }

    @Test
    public void addSameIngredientTwice() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Assertions.assertThat(burger.ingredients)
                .withFailMessage("Не удалось добавить ингрeдиенты")
                .containsExactly(ingredient, ingredient);
    }

    @Test
    public void addTwoIngredients() {
        Ingredient another = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(another);

        Assertions.assertThat(burger.ingredients)
                .withFailMessage("Не удалось добавить ингрeдиенты")
                .containsExactly(ingredient, another);
    }
}
