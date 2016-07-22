package letters;

/**
 * Created by iciuta on 7/22/2016.
 */
public class LetterMapping {
    private char letter;
    private int mappedValue;

    public LetterMapping(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getMappedValue() {
        return mappedValue;
    }

    public void setMappedValue(int mappedValue) {
        this.mappedValue = mappedValue;
    }

    @Override
    public String toString() {
        return letter + " -> " + mappedValue;
    }
}
