package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.AbstractDao;
import com.endava.jpa.dao.ProjectDao;
import com.endava.jpa.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {
    private final String QUERY_FIND_ALL = "SELECT p FROM Project p";

    public List<Project> findAll() {
        return entityManager.createQuery(QUERY_FIND_ALL).getResultList();
    }
}
