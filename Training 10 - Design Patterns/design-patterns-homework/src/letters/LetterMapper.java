package letters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 7/22/2016.
 */
public class LetterMapper {
    private LetterMapper() {}

    public static LetterMapping mapLetter(char letter) {
        if(!(letter >= 'a' && letter <= 'z') && !(letter >= 'A' && letter <= 'Z')) {
            throw new UnsupportedOperationException(letter + " is not a letter!");
        }

        LetterMapping letterMapping = new LetterMapping(letter);
        letterMapping.setMappedValue((Character.toLowerCase(letter) - 'a') + 1);
        return letterMapping;
    }

    public static List<LetterMapping> mapAlphabet() {
        List<LetterMapping> result = new ArrayList<>();
        for(int i = 'a'; i <= 'z'; i++) {
            result.add(mapLetter((char)i));
        }
        return result;
    }
}
