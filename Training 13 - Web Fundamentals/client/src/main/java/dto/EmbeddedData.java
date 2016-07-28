package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by iciuta on 7/28/2016.
 */
public class EmbeddedData implements Serializable{
    /*List of comments*/
    private List<Comment> comment;

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
