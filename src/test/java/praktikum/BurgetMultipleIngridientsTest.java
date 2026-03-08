package praktikum;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BurgetMultipleIngridientsTest {
    private final Burger burger;
    private final Ingredient firstIngredient;
    private final Ingredient ingredientInTheMiddle;
    private final Ingredient lastIngredient;

    public BurgetMultipleIngridientsTest() {
        burger = new Burger();

        firstIngredient = MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Пиявка сушёная", 25f);
        ingredientInTheMiddle = MockBurgerUtils.mockIngredient(IngredientType.FILLING, "Тина болотная", 5f);
        lastIngredient = MockBurgerUtils.mockIngredient(IngredientType.SAUCE, "Жабья кровь", 10f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(ingredientInTheMiddle);
        burger.addIngredient(lastIngredient);
    }


    @Test
    public void removeFirstIngridient() {
        burger.removeIngredient(0);

        Assertions.assertThat(burger.ingredients).containsExactly(ingredientInTheMiddle, lastIngredient);
    }

    @Test
    public void removeIngridientInTheMiddle() {
        burger.removeIngredient(1);

        Assertions.assertThat(burger.ingredients).containsExactly(firstIngredient, lastIngredient);
    }

    @Test
    public void removeLastIngridient() {
        burger.removeIngredient(2);

        Assertions.assertThat(burger.ingredients).containsExactly(firstIngredient, ingredientInTheMiddle);
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

        Assertions.assertThat(burger.ingredients).containsExactly(ingredientInTheMiddle, firstIngredient, lastIngredient);
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
