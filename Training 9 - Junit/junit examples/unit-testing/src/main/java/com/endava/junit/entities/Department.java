package com.endava.junit.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private List<Employee> employeeList;
	private String departmentName;

	public Department() {
		this.employeeList = new ArrayList<Employee>();
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
