package com.endava.jpa.service.impl;

import com.endava.jpa.dao.ProjectDao;
import com.endava.jpa.model.Project;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public Project find(Long id) {
        return projectDao.find(id);
    }

    public void save(Project toBeSaved) {
        projectDao.save(toBeSaved);
    }

    public void update(Project toBeUpdated) {
        projectDao.update(toBeUpdated);
    }

    public void delete(Project toBeRemoved) {
        projectDao.delete(toBeRemoved);
    }

    public List<Project> findAll() {
        return projectDao.findAll();
    }
}
