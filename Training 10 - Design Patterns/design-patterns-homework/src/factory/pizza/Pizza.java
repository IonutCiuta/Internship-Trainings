package factory.pizza;

/**
 * Created by iciuta on 7/22/2016.
 */
public abstract class Pizza {
    public void bake() {
        System.out.println("Baking " + getClass().getSimpleName());
    }
}
