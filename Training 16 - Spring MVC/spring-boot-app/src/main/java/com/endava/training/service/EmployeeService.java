package com.endava.training.service;

import com.endava.training.model.Employee;

import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
public interface EmployeeService {
    List<Employee> findAllEmployees();
}
