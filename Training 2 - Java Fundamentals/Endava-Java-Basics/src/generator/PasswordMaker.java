package generator;

import java.util.Random;
import java.util.UUID;

/**
 * Created by iciuta on 7/7/2016.
 */
public class PasswordMaker {
    private final int MAGIC_NUMBER = 7;
    private final String MAGIC_STRING = UUID.randomUUID().toString(); /*UUID's are 32 chars. long*/

    private String firstName, lastName;
    private int age;

    public PasswordMaker(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getPassword() {
        int index;
        StringBuilder builder;
        RandomStringGenerator generator;
        String alphabet, start, middle, end;

        /*generating start part*/
        index = age % 3;
        start = firstName.substring(index);

        /*generating middle part*/
        generator = new RandomStringGenerator(10, MAGIC_STRING);
        alphabet = generator.next();
        generator = new RandomStringGenerator(MAGIC_NUMBER, alphabet);
        middle = generator.next();

        /*generating end part*/
        end = age + firstName.length() + "";

        /*adding up the parts*/
        builder = new StringBuilder();
        builder.append(start).append(middle).append(end);

        return builder.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
