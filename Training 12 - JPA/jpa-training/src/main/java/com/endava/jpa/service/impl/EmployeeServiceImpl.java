package com.endava.jpa.service.impl;

import com.endava.jpa.criteria.EmployeeCriteria;
import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public List<Employee> findAllForDepartment(Department department) {
        return null;
    }

    public Employee find(Long id) {
        return employeeDao.find(id);
    }

    public void save(Employee toBeSaved) {
        employeeDao.save(toBeSaved);
    }

    public void update(Employee toBeUpdated) {
        employeeDao.update(toBeUpdated);
    }

    public void delete(Employee toBeRemoved) {
        employeeDao.delete(toBeRemoved);
    }

    public List<Employee> findAllForCriteria(EmployeeCriteria criteria) {
        return employeeDao.findByCriteria(criteria);
    }
}
