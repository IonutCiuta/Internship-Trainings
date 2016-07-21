package com.endava.junit.read;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.endava.junit.entities.Employee;

public class EmployeeReaderTestCase {

	private ReaderInterface reader;

	@Test
	public void testRealImplementation() {
		reader = new EmployeeReader();
		List<Employee> result = reader.readEmployees();
		assertEquals(30, result.size());
	}

	@Test
	public void testStubImplementation() {
		reader = new ReaderStub();
		List<Employee> result = reader.readEmployees();
		assertEquals(1, result.size());
	}

}
