package com.endava.junit.read;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.endava.junit.entities.Employee;

public class EmployeeReader implements ReaderInterface {

	public List<Employee> readEmployees() {
		List<String> positionList = new ArrayList<String>(Arrays.asList(
				"Architect", "Developer", "Tester", "Other"));
		List<Employee> employeeList = new ArrayList<Employee>();
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			Employee employee = new Employee(i, "Employee" + i, new Date(i * 50000000000L ),
					random.nextInt(7), positionList.get(random.nextInt(4)));
			employeeList.add(employee);
		}
		return employeeList;
	}

}
