package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.AbstractDao;
import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao{
	private final String QUERY_FIND_DEPARTMENT_BY_NAME = "Select d from Department d where d.name = :dep_name";
	private final String QUERY_FIND_ALL = "SELECT d FROM Department d";

	public List<Department> find(String departmentName) {
		return entityManager.createQuery(QUERY_FIND_DEPARTMENT_BY_NAME)
				.setParameter("dep_name", departmentName)
				.getResultList();
	}

	public List<Department> findAll() {
		return entityManager.createQuery(QUERY_FIND_ALL).getResultList();
	}
}
