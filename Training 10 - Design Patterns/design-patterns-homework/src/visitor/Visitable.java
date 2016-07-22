package visitor;

/**
 * Created by iciuta on 7/22/2016.
 */
public interface Visitable {
    int accept(DocumentVisitor visitor);
}
