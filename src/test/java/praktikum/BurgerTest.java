package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Bun bun = Mockito.mock(Bun.class);
    private final Ingredient ingredient = Mockito.mock(Ingredient.class);
    private final Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(burger.ingredients.size()).isEqualTo(1);
        soft.assertThat(burger.ingredients.get(0)).isSameAs(ingredient);
        soft.assertAll();
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(1);

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(burger.ingredients.size()).isEqualTo(1);
        soft.assertThat(burger.ingredients.get(0)).isSameAs(ingredient);
        soft.assertAll();
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1, 0);

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(burger.ingredients.size()).isEqualTo(2);
        soft.assertThat(burger.ingredients.get(0)).isSameAs(ingredient2);
        soft.assertThat(burger.ingredients.get(1)).isSameAs(ingredient);
        soft.assertAll();
    }
}
