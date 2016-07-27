package com.endava.jpa.dao;

import com.endava.jpa.criteria.EmployeeCriteria;
import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeDao extends Dao<Employee, Long> {
    List<Employee> findAll();
    List<Employee> findByCriteria(EmployeeCriteria criteria);
}
