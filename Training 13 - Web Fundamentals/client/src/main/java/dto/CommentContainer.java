package dto;

import java.io.Serializable;

/**
 * Created by iciuta on 7/28/2016.
 */
public class CommentContainer implements Serializable {
    /*Contains comments*/
    private EmbeddedData _embedded;

    public EmbeddedData getEmbeddedData() {
        return _embedded;
    }

    public void setEmbeddedData(EmbeddedData _embedded) {
        this._embedded = _embedded;
    }
}
