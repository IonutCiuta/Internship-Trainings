package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public class SimpleDocumentPrinter implements DocumentPrinter {
    @Override
    public void print(Document document) {
        System.out.println(
                "Document: " + document.getName() +
                System.lineSeparator() +
                "Analytics: " + document.getWordCount() + " words, " + document.getCharacterCount() + " character" +
                System.lineSeparator() + System.lineSeparator() +
                document.getText()
        );

    }
}
