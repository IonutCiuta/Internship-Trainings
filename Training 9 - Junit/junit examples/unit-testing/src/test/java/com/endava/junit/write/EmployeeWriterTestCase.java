package com.endava.junit.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.endava.junit.entities.Department;
import com.endava.junit.entities.Employee;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeWriter.class)
public class EmployeeWriterTestCase {

	private EmployeeWriter writer;

	@Before
	public void setUp() throws Exception {
		writer = new EmployeeWriter();
		FileWriter fileWriter = Mockito.mock(FileWriter.class);
		PowerMockito.whenNew(FileWriter.class)
				.withArguments(Mockito.anyString()).thenReturn(fileWriter);
		BufferedWriter bufferedWriter = Mockito.mock(BufferedWriter.class);
		PowerMockito.whenNew(BufferedWriter.class).withArguments(fileWriter)
				.thenReturn(bufferedWriter);
		PowerMockito.field(EmployeeWriter.class, "testField").set(writer, "value");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteEmployees() {
		Map<String, Department> departments = new HashMap<String, Department>();
		Department department = new Department();
		department.setDepartmentName("testvalue");
		Employee employee = new Employee(0, "test", new Date(), 0, "test");
		department.getEmployeeList().add(employee);
		departments.put("testKey", department);
		writer.writeEmployees(departments);
	}

}
