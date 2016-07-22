package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public class Document implements Visitable{
    private String name;
    private String text;
    private int wordCount;
    private int characterCount;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    @Override
    public int accept(DocumentVisitor visitor) {
        return visitor.visit(this);
    }
}
