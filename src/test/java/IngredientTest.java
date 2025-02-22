import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "T", 1},
                {FILLING, null, 0},
                {SAUCE, "TestName", -1},
                {FILLING, "", -0.1F}
        };
    }

    @Test
    public void testGetName() {
        String actualName = ingredient.getName();
        Assert.assertEquals("Incorrect name", actualName, name);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = Float.parseFloat(ingredient.getPrice().toString());
        Assert.assertEquals("Incorrect price", actualPrice, price, 0.0);
    }

    @Test
    public void testIngredientType() {
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals("Incorrect type", actualIngredientType, type);
    }
}
