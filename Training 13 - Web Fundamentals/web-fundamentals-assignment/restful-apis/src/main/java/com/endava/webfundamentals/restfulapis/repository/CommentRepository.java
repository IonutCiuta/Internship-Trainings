package com.endava.webfundamentals.restfulapis.repository;

import com.endava.webfundamentals.restfulapis.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by fstancu on 7/22/2016.
 */

@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findByEmail(@Param("email") String email);

}
