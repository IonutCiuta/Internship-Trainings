package com.endava.junit.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.endava.junit.entities.Employee;

public class EmployeeServiceTestCase {

	private EmployeeService employeeService;

	private Employee employee;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		employeeService = new EmployeeService();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	// @Test(expected = NullPointerException.class)
	// if you expect an Exception
	@Test
	public void testFindDepartmentForEmployeeWithEmployeeNull() {
		employee = null;
		String actual = employeeService.findDepartmentForEmployee(employee);
		assertNull(actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeeNotNull() {
		employee = new Employee(0, "", new Date(), 0, "");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Analysis";
		assertEquals(expected, actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeePositionDeveloper() {
		employee = new Employee(0, "", new Date(), 0, "developer");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Development";
		assertEquals(expected, actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeePositionTester() {
		employee = new Employee(0, "", new Date(), 0, "tester");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Testing";
		assertEquals(expected, actual);
	}

	@Test
	public void testFindDepartmentForEmployeeWithEmployeePositionArchitect() {
		employee = new Employee(0, "", new Date(), 0, "architect");
		String actual = employeeService.findDepartmentForEmployee(employee);
		String expected = "Architecture";
		assertEquals(expected, actual);
	}

}
