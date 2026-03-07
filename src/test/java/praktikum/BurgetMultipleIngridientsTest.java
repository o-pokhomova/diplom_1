package praktikum;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BurgetMultipleIngridientsTest {
    private final Burger burger;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final Ingredient ingredient3;
    private final List<Ingredient> initialIngridients;

    public BurgetMultipleIngridientsTest() {
        burger = new Burger();

        ingredient1 = new Ingredient(IngredientType.FILLING, "Пиявка сушёная", 25f);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Тина болотная", 5f);
        ingredient3 = new Ingredient(IngredientType.SAUCE, "Жабья кровь", 10f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        initialIngridients = Arrays.asList(ingredient1, ingredient2, ingredient3);
    }

    @Test
    public void removeFirstIngridient() {
        burger.removeIngredient(0);

        Assertions.assertThat(burger.ingredients).containsExactly(ingredient2, ingredient3);
    }

    @Test
    public void removeIngridientInTheMiddle() {
        burger.removeIngredient(1);

        Assertions.assertThat(burger.ingredients).containsExactly(ingredient1, ingredient3);
    }

    @Test
    public void removeLastIngridient() {
        burger.removeIngredient(2);

        Assertions.assertThat(burger.ingredients).containsExactly(ingredient1, ingredient2);
    }

    @Test
    public void removeIngredientIncorrectIndexLeft() {
        Assertions.assertThatThrownBy(() -> burger.removeIngredient(-1))
                .withFailMessage("Удаление по несуществующему индексу должно вызывать ошибку")
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void removeIngredientIncorrectIndexRight() {
        Assertions.assertThatThrownBy(() -> burger.removeIngredient(4))
                .withFailMessage("Удаление по несуществующему индексу должно вызывать ошибку")
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void moveFirstIngridient() {
        burger.moveIngredient(0, 1);

        Assertions.assertThat(burger.ingredients).containsExactly(ingredient2, ingredient1, ingredient3);
    }

    @Test
    public void moveFirstIngredientFromIncorrectIndex() {
        Assertions.assertThatThrownBy(() -> burger.moveIngredient(-1, 1))
                .withFailMessage("Нельзя перемещать ингрeдиенты с несуществующей позиции")
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void moveFirstIngredientToIncorrectIndex() {
        Assertions.assertThatThrownBy(() -> burger.moveIngredient(1, 4))
                .withFailMessage("Нельзя перемещать ингрeдиенты на несуществующую позицию")
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void moveFirstIngredientBetweenIncorrectIndexes() {
        Assertions.assertThatThrownBy(() -> burger.moveIngredient(-1, 4))
                .withFailMessage("Нельзя перемещать ингрeдиенты между несуществующими позициями")
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
