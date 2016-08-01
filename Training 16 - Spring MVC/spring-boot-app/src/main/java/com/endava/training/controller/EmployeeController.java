package com.endava.training.controller;

import com.endava.training.dto.EmployeeDTO;
import com.endava.training.model.Employee;
import com.endava.training.service.EmployeeService;
import com.endava.training.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ViewService viewService;

    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for(Employee employee : employees) {
            employeeDTOs.add(viewService.convertEmployee(employee));
        }

        return employeeDTOs;
    }
}
