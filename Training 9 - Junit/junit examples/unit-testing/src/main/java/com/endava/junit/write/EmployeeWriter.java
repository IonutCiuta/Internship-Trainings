package com.endava.junit.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.endava.junit.entities.Department;
import com.endava.junit.entities.Employee;

public class EmployeeWriter {

	private String testField;
	
	public void writeEmployees(Map<String, Department> departments) {
		String fileName = "D:/java-junit/employeeFile.txt";
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			System.out.println("testField value:" +testField);
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (Department d : departments.values()) {
				bufferedWriter.write(d.getDepartmentName());
				bufferedWriter.newLine();
				for (Employee e : d.getEmployeeList()) {
					bufferedWriter.write(e.toString());
					bufferedWriter.newLine();
				}
			}
			bufferedWriter.flush();
		} catch (IOException ex) {
			System.out.println("I/O Exception:" + ex.getMessage());
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				System.out.println("I/O Exception:" + ex.getMessage());
			}
		}
	}

}
