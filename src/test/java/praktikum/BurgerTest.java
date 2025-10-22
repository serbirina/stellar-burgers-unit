package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Bun bun = Mockito.mock(Bun.class);
    private final Ingredient ingredient = Mockito.mock(Ingredient.class);
    private final Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(1);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertSame(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1, 0);

        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertSame(ingredient2, burger.ingredients.get(0));
        Assert.assertSame(ingredient, burger.ingredients.get(1));
    }
}
