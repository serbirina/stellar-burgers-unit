package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParameterizedTest {
    private final Burger burger = new Burger();
    private final Bun bun = Mockito.mock(Bun.class);

    private final String nameBun;
    private final List<String> nameIngredient;
    private final List<IngredientType> typeOfIngredient;

    public BurgerGetReceiptParameterizedTest(String setBun, List<String> setIngredient, List<IngredientType> typeOfIngredient) {
        this.nameBun = setBun;
        this.nameIngredient = setIngredient;
        this.typeOfIngredient = typeOfIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"black bun", List.of("cutlet"), List.of(FILLING)},
                {"white bun", List.of("sour cream", "dinosaur"), List.of(SAUCE, FILLING)},
                {"red bun", List.of("chili sauce", "sausage", "hot sauce"), List.of(SAUCE, FILLING, SAUCE)}
        };
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(nameBun);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", nameBun));

        for (int i = 0; i < nameIngredient.size(); i++) {
            Ingredient ingredient = Mockito.mock(Ingredient.class);

            Mockito.when(ingredient.getType()).thenReturn(typeOfIngredient.get(i));
            Mockito.when(ingredient.getName()).thenReturn(String.valueOf(nameIngredient.get(i)));

            burger.addIngredient(ingredient);

            expectedReceipt.append(String.format("= %s %s =%n", typeOfIngredient.get(i).toString().toLowerCase(), nameIngredient.get(i)));
        }

        expectedReceipt.append(String.format("(==== %s ====)%n", nameBun));
        expectedReceipt.append(String.format("%nPrice: 0,000000%n"));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
