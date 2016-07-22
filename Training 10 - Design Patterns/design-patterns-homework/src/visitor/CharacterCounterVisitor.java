package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public class CharacterCounterVisitor implements DocumentVisitor {
    @Override
    public int visit(Document document) {
        /*considering everything is a character (space and so on)*/
        return document.getText().length();
    }
}
