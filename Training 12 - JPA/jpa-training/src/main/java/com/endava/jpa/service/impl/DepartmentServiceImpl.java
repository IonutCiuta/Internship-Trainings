package com.endava.jpa.service.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public Department find(Long id) {
		return departmentDao.find(id);
	}

	public List<Department> find(String departmentName) {
		return departmentDao.find(departmentName);
	}

	@Transactional
	public void save(Department toBeSaved) {
		departmentDao.save(toBeSaved);
	}

	@Transactional
	public void update(Department toBeUpdated) {
		departmentDao.update(toBeUpdated);
	}

	@Transactional
	public void delete(Department toBeRemoved) {
		departmentDao.delete(toBeRemoved);
	}
}
