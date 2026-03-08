package praktikum;

import org.mockito.Mockito;

public class MockBurgerUtils {
    public static Ingredient mockIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(name);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    public static Bun mockBun() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(20f);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        return bun;
    }
}
