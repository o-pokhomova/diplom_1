package praktikum;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerIngredientTest {
    private final Burger burger;
    private final Ingredient ingredient;

    public BurgerIngredientTest(IngredientType ingredientType) {
        burger = new Burger();
        ingredient = new Ingredient(ingredientType, "Секретный ингрeдиент", 25f);
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
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Второй ингрeдиент", 10f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        Assertions.assertThat(burger.ingredients)
                .withFailMessage("Не удалось добавить ингрeдиенты")
                .containsExactly(ingredient, ingredient2);
    }
}
