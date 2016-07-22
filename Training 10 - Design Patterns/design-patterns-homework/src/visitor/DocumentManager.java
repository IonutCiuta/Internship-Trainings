package visitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by iciuta on 7/22/2016.
 */
public class DocumentManager {
    public static Document storeDocument(String filename) {
        Document document = new Document(filename);

        try(BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            StringBuilder documentTextBuilder = new StringBuilder();
            String line;

            while((line = fileReader.readLine()) != null) {
                documentTextBuilder.append(line);
                documentTextBuilder.append(System.lineSeparator());
            }

            document.setText(documentTextBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public static void analyzeDocument(Document document) {
        document.setCharacterCount(document.accept(new CharacterCounterVisitor()));
        document.setWordCount(document.accept(new WordCounterVisitor()));
    }
}
