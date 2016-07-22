package letters;

import java.util.List;

/**
 * Created by iciuta on 7/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<LetterMapping> alphabetMapping = LetterMapper.mapAlphabet();
        System.out.println(alphabetMapping);
        System.out.println(LetterMapper.mapLetter('H'));
    }
}
