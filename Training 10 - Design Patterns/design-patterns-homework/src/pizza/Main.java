package pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 7/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Pizza> pizzaOrders = new ArrayList<>();

        for(PizzaType type : PizzaType.values()) {
            pizzaOrders.add(PizzaBakery.preparePizza(type));
        }

        for (Pizza pizza : pizzaOrders) {
            pizza.bake();
        }
    }
}
