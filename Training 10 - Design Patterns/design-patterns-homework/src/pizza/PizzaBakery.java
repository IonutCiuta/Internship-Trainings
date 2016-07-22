package pizza;

/**
 * Created by iciuta on 7/22/2016.
 */
public class PizzaBakery {
    private PizzaBakery() {}

    public static Pizza preparePizza(PizzaType pizzaType) {
        switch (pizzaType) {
            case DELUXE:
                return new DeluxePizza();

            case HAM_AND_MUSHROOMS:
                return new HamAndMushroomsPizza();

            case PROSCIUTO:
                return new ProsciutoPizza();

            case DIAVOLA:
                return new DivolaPizza();

            default:
                return null;
        }
    }
}
