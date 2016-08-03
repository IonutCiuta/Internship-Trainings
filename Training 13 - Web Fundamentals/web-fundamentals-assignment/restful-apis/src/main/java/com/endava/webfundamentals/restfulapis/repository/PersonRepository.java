package com.endava.webfundamentals.restfulapis.repository;

import com.endava.webfundamentals.restfulapis.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by fstancu on 7/22/2016.
 */

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByFirstName(@Param("name") String firstName);

}
