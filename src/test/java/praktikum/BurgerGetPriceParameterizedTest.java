package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerGetPriceParameterizedTest {
    private final Burger burger = new Burger();
    private final Bun bun = Mockito.mock(Bun.class);

    private final float priceBun;
    private final List<Float> priceIngredients;
    private final float expectedPrice;

    public BurgerGetPriceParameterizedTest(float priceBun, List<Float> priceIngredient, float expectedPrice) {
        this.priceBun = priceBun;
        this.priceIngredients = priceIngredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Expected total price to be {2} with bun price {0} and ingredients price {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {100f, List.of(200F), 400f},
                {200f, List.of(100F, 300F), 800f},
                {300f, List.of(100F, 300F, 200F), 1200f}
        };
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        for (Float priceIngredient : priceIngredients) {
            Ingredient ingredient = Mockito.mock(Ingredient.class);
            Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient);
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.0001f);
    }
}
