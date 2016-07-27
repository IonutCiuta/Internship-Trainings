package com.endava.jpa.dao;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentDao extends Dao<Department, Long> {
	List<Department> find(String name);
}
