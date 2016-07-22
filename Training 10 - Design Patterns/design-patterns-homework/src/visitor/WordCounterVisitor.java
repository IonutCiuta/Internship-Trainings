package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public class WordCounterVisitor implements DocumentVisitor {
    @Override
    public int visit(Document document) {
        return document.getText().split(" ").length;
    }
}
