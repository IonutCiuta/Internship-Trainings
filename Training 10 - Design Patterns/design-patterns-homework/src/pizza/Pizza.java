package pizza;

/**
 * Created by iciuta on 7/22/2016.
 */
public abstract class Pizza {
    protected void bake() {
        System.out.println("Baking " + getClass().getSimpleName());
    }
}
