package com.endava.junit.process;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.endava.junit.entities.Department;
import com.endava.junit.entities.Employee;
import com.endava.junit.services.EmployeeService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeProcessor.class)
public class EmployeeProcessorTestCase {

	private EmployeeProcessor processor;

	private EmployeeService service;

	private List<Employee> employeeList;

	@Before
	public void setUp() throws Exception {
		processor = new EmployeeProcessor();
		employeeList = new ArrayList<Employee>();
		Employee employee1 = new Employee(1, "test 1", new Date(), 1,
				"department");
		Employee employee2 = new Employee(2, "test 2", new Date(), 2,
				"department");
		Employee employee3 = new Employee(3, "test 3", new Date(), 3, "test");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
	}

	// For Mock you have to tell it what to do. By default when you call a
	// method from a mock it doesn't do anything
	@Test
	public void testProcessEmployeesWithMockDefault() throws Exception {
		System.out.println("You are in testProcessEmployeesWithMockDefault");
		service = Mockito.mock(EmployeeService.class);
		PowerMockito.whenNew(EmployeeService.class).withNoArguments()
				.thenReturn(service);
		Map<String, Department> result = processor
				.processEmployees(employeeList);
		assertEquals(1, result.values().size());
	}

	@Test
	public void testProcessEmployeesWithMockCallRealMethod() throws Exception {
		System.out
				.println("You are in testProcessEmployeesWithMockCallRealMethod");
		service = Mockito.mock(EmployeeService.class);
		Mockito.when(
				service.findDepartmentForEmployee(Mockito.any(Employee.class)))
				.thenCallRealMethod();
		PowerMockito.whenNew(EmployeeService.class).withNoArguments()
				.thenReturn(service);
		Map<String, Department> result = processor
				.processEmployees(employeeList);
		assertEquals(1, result.values().size());
	}

	@Test
	public void testProcessEmployeesWithMock() throws Exception {
		System.out.println("You are in testProcessEmployeesWithMock");
		service = Mockito.mock(EmployeeService.class);
		Mockito.when(
				service.findDepartmentForEmployee(Mockito.any(Employee.class)))
				.thenReturn("Department", "Department", "Other");
		PowerMockito.whenNew(EmployeeService.class).withNoArguments()
				.thenReturn(service);
		Map<String, Department> result = processor
				.processEmployees(employeeList);
		assertEquals(2, result.values().size());
	}

	// For Spy you have to tell it what not to do. By default when you call a
	// method from a spy it runs through the method as normal
	@Test
	public void testProcessEmployeesWithSpyDefault() throws Exception {
		System.out.println("You are in testProcessEmployeesWithSpyDefault");
		service = Mockito.spy(EmployeeService.class);
		PowerMockito.whenNew(EmployeeService.class).withNoArguments()
				.thenReturn(service);
		Map<String, Department> result = processor
				.processEmployees(employeeList);
		assertEquals(1, result.values().size());
	}

	@Test
	public void testProcessEmployeesWithSpy() throws Exception {
		System.out.println("You are in testProcessEmployeesWithSpy");
		service = Mockito.spy(EmployeeService.class);
		Mockito.when(
				service.findDepartmentForEmployee(Mockito.any(Employee.class)))
				.thenReturn("Department", "Department", "Other");
		PowerMockito.whenNew(EmployeeService.class).withNoArguments()
				.thenReturn(service);
		Map<String, Department> result = processor
				.processEmployees(employeeList);
		assertEquals(2, result.values().size());
	}
}
