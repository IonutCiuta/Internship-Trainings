package com.endava.training.service.impl;

import com.endava.training.dao.EmployeeRepository;
import com.endava.training.model.Employee;
import com.endava.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeDAO;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }
}
