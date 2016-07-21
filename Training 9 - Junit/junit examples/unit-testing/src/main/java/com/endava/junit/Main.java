package com.endava.junit;

import java.util.List;
import java.util.Map;

import com.endava.junit.entities.Department;
import com.endava.junit.entities.Employee;
import com.endava.junit.process.EmployeeProcessor;
import com.endava.junit.read.EmployeeReader;
import com.endava.junit.write.EmployeeWriter;

public class Main {

	public static void main(String[] args) {
		EmployeeReader reader = new EmployeeReader();
		EmployeeProcessor processor = new EmployeeProcessor();
		EmployeeWriter writer = new EmployeeWriter();
		List<Employee> employeeList = reader.readEmployees();
		Map<String, Department> departments = processor.processEmployees(employeeList);
		writer.writeEmployees(departments);
	}

}
