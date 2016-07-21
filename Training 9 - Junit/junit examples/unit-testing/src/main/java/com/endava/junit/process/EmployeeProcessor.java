package com.endava.junit.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.endava.junit.entities.Department;
import com.endava.junit.entities.Employee;
import com.endava.junit.services.EmployeeService;

public class EmployeeProcessor {

	public Map<String, Department> processEmployees(List<Employee> employeeList) {
		EmployeeService employeeService = new EmployeeService();
		Map<String, Department> departmentMap = new HashMap<String, Department>();
		for (Employee e : employeeList) {
			String departmentName = employeeService.findDepartmentForEmployee(e);
			Department department = departmentMap.get(departmentName);
			if(department == null){
				Department newDepartment = new Department();
				newDepartment.setDepartmentName(departmentName);
				newDepartment.getEmployeeList().add(e);
				departmentMap.put(departmentName, newDepartment);
			} else {
				department.getEmployeeList().add(e);
				departmentMap.put(departmentName, department);
			}
		}
		return departmentMap;
	}

}
