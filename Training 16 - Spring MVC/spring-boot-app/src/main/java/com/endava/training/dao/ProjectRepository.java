package com.endava.training.dao;

import com.endava.training.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iciuta on 8/1/2016.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
}
