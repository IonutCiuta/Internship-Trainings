package com.endava.jpa.service;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentService extends BaseService<Department, Long> {
	List<Department> find(String name);
	List<Department> findAll();
}
