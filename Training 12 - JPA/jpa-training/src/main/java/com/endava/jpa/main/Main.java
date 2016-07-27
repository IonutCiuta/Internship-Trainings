package com.endava.jpa.main;

import com.endava.jpa.service.impl.JPAMainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JPAMainService jpaMainService = (JPAMainService)context.getBean("JPAMainService");

		//Starting up with a fresh database
		System.out.println("INIT:");
		jpaMainService.cleanUp();
		jpaMainService.setUp();
		System.out.println();

		//Exercises
		System.out.println("EXERCISES: ");

		//Department
		jpaMainService.insertDepartment();
		jpaMainService.findDepartment();
		jpaMainService.findDepartmentByName();
		jpaMainService.updateDepartment();

		//Employee
		jpaMainService.insertEmployee();
		jpaMainService.getEmployeesFromBucharest();
		jpaMainService.giveSalaryRaise();
		jpaMainService.removeEmployee();
	}
}
