package com.endava.junit.read;

import com.endava.junit.entities.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderStub implements ReaderInterface {

	public List<Employee> readEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee(0, "test", new Date(), 0, "test");
		employeeList.add(employee);
		return employeeList;
	}

}
