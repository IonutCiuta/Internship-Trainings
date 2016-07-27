package com.endava.jpa.service;

import com.endava.jpa.criteria.EmployeeCriteria;
import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, Long>{
    List<Employee> findAll();
    List<Employee> findAllForCriteria(EmployeeCriteria criteria);
}
