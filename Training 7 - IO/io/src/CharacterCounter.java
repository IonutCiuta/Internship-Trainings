import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by iciuta on 7/19/2016.
 */
public class CharacterCounter {
    public static int count(String filename, char target) {
        int result = 0;

        try(FileReader reader = new FileReader(filename)) {
            int read;
            while((read = reader.read()) != -1) {
                char current = (char) read;
                if(current == target) result++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
