package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        DocumentPrinter printer = new SimpleDocumentPrinter();
        Document document = DocumentManager.storeDocument("document");
        DocumentManager.analyzeDocument(document);
        printer.print(document);
    }
}
