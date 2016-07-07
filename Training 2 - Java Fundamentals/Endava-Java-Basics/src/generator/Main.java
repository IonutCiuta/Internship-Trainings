package generator;

/**
 * Created by iciuta on 7/7/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Random strings: ");
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator(5, "1ZCB&ky0.");
        System.out.println(randomStringGenerator.next());
        System.out.println(randomStringGenerator.next());

        System.out.println("Passwords: ");
        PasswordMaker passwordMaker = new PasswordMaker("Ionut", "Ciuta", 23);
        System.out.println(passwordMaker.getPassword());
        System.out.println(passwordMaker.getPassword());
    }
}
