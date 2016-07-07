package generator;

import java.util.Random;

/**
 * Created by iciuta on 7/7/2016.
 */
public class RandomStringGenerator {
    private int stringLength;
    private String alphabet;

    public RandomStringGenerator(int stringLength, String alphabet) {
        this.stringLength = stringLength;
        this.alphabet = alphabet;
    }

    public String next() {
        StringBuilder builder = new StringBuilder();
        char[] chars = alphabet.toCharArray();
        Random generator = new Random();

        for(int i = 0; i < stringLength; i++) {
            int index = generator.nextInt(stringLength);
            builder.append(chars[index]);
        }

        return builder.toString();
    }

    public int getStringLength() {
        return stringLength;
    }

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
}
