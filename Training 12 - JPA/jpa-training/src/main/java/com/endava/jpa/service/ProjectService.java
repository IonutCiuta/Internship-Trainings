package com.endava.jpa.service;

import com.endava.jpa.model.Project;

import java.util.List;

public interface ProjectService extends BaseService<Project, Long>{
    List<Project> findAll();
}
