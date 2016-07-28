package web.service;

import dto.Comment;

import java.util.List;

/**
 * Created by iciuta on 7/27/2016.
 */
public interface CommentWebServiceClient {
    void save(Comment comment);
    void update(Comment comment);
    Comment findById(Long commentId);
    List<Comment> findAll();
    void delete(Comment comment);
}
